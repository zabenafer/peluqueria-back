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
import com.backend.peluqueriaback.entity.Venta;
import com.backend.peluqueriaback.service.VentaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	VentaService ventaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Venta>> getAllVenta() {
		List<Venta> venta = ventaService.findAllVenta();
		return new ResponseEntity<List<Venta>>(venta, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Venta> addVenta(@RequestBody Venta venta) {
		try {
			if (Objects.isNull(venta.getCliente().getId_cliente()))  
				return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
			Venta newVenta = ventaService.addVenta(venta);
			return new ResponseEntity<>(newVenta, HttpStatus.CREATED);			
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
