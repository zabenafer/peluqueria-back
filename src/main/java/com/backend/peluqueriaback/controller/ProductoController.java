package com.backend.peluqueriaback.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.backend.peluqueriaback.entity.Producto;
import com.backend.peluqueriaback.service.ProductoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Producto>> getAllProducto() {
		List<Producto> producto = productoService.findAllProducto();
		return new ResponseEntity<List<Producto>>(producto, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Producto> addProducto(@RequestBody Producto producto) {
		try {
			if (StringUtils.isBlank(producto.getNombre())) 
				return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
			if (producto.getPrecio() <= 0) 
				return new ResponseEntity(new Mensaje("El Precio es obligatorio"), HttpStatus.BAD_REQUEST);
			Producto newProducto = productoService.addProducto(producto);
			return new ResponseEntity<>(newProducto, HttpStatus.CREATED);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
		if (StringUtils.isBlank(producto.getNombre())) 
			return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if (producto.getPrecio() <= 0) 
			return new ResponseEntity(new Mensaje("El Precio es obligatorio"), HttpStatus.BAD_REQUEST);
		Producto updateProducto = productoService.updateProducto(producto);
		return new ResponseEntity<>(updateProducto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProducto(@PathVariable("id") Long id) {
		productoService.deleteProducto(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
