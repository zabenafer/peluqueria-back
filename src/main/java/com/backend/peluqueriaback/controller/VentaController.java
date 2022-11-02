package com.backend.peluqueriaback.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.peluqueriaback.dto.Mensaje;
import com.backend.peluqueriaback.entity.DetalleVenta;
import com.backend.peluqueriaback.entity.Producto;
import com.backend.peluqueriaback.entity.Turno;
import com.backend.peluqueriaback.entity.Venta;
import com.backend.peluqueriaback.repository.DetalleVentaRepository;
import com.backend.peluqueriaback.service.DetalleVentaService;
import com.backend.peluqueriaback.service.ProductoService;
import com.backend.peluqueriaback.service.VentaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/venta")
public class VentaController {
	
	
	@Autowired
	VentaService ventaService;
	
	@Autowired
	DetalleVentaService detalleVentaService;
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	DetalleVentaRepository detalleVentaRepository;
	
	DetalleVenta detalleVenta;
	
	@GetMapping("/all")
	public ResponseEntity<List<Venta>> getAllVenta() {
		List<Venta> venta = ventaService.findAllVenta();
		return new ResponseEntity<List<Venta>>(venta, HttpStatus.OK);
	}
	
	@GetMapping("/finddetalleventaxventa/{id}")
	public ResponseEntity<List<DetalleVenta>> getDetalleVentaXVenta(@PathVariable("id") Long id_venta) {
		List<DetalleVenta> detalleVenta = detalleVentaService.findByDetalleVentaXVenta(id_venta);
		return new ResponseEntity<List<DetalleVenta>>(detalleVenta, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Venta> addVenta(@RequestBody Venta venta) {
		try {
			System.out.println("ENTRE");
			float montoTotal = 0;
			Long codVenta = (long) 0;
			int cantidad = 0;
			int cantStock = 0;
			Long idProducto;
			
			//Codigo para ir agregando el codigo de la venta automaticamente.
			List<Venta> ultimaVenta = ventaService.findUltioCodigoVenta();
			System.out.println("codigoVenta: "+ ultimaVenta);			
			for (Venta vent: ultimaVenta) {
				codVenta = vent.getCod_venta() + 1;
			}			
			venta.setCod_venta(codVenta);
			System.out.println("codigoVenta: "+ venta.getCod_venta());
			
				
			List<DetalleVenta> detalles = venta.getDetalleVenta();
			System.out.println("detalles: " + detalles);
			venta.setDetalleVenta(null);
			Venta newVenta = ventaService.addVenta(venta);
			System.out.println("Venta: " + newVenta);
			
			for (DetalleVenta det: detalles) {
				
				det.setId_venta(venta.getId_venta());
				montoTotal = montoTotal + det.getPrecio();
				
				//Resto la cantidad que se vendio al stock del producto.
				cantidad = det.getCantidad();
				idProducto = det.getId_producto();
				Producto producto = productoService.findProductoById(idProducto);
				cantStock = producto.getCantidad();
				producto.setCantidad(cantStock - cantidad);
				Producto updateProducto = productoService.updateProducto(producto);
			}
			System.out.println("newVenta: " + newVenta);
			System.out.println("montoTotal: " + montoTotal);
			venta.setMonto_total(montoTotal);
			
			Venta updateVenta = ventaService.updateVenta(newVenta);			
			detalleVentaRepository.saveAll(detalles);
			venta.setDetalleVenta(detalles);
			
			
			return new ResponseEntity<>(venta, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Venta> updateVenta(@RequestBody Venta venta) {
		if (Objects.isNull(venta.getCliente().getId_cliente())) 
			return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Venta updateVenta = ventaService.updateVenta(venta);
		return new ResponseEntity<>(updateVenta, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteVenta(@PathVariable("id") Long id) {
		ventaService.deleteVenta(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
