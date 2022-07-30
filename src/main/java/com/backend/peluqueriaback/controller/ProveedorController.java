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
import com.backend.peluqueriaback.entity.Proveedor;
import com.backend.peluqueriaback.service.ProductoService;
import com.backend.peluqueriaback.service.ProveedorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	ProveedorService proveedorService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Proveedor>> getAllProveedor() {
		List<Proveedor> proveedor = proveedorService.findAllProveedor();
		return new ResponseEntity<List<Proveedor>>(proveedor, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Proveedor> addProveedor(@RequestBody Proveedor proveedor) {
		try {
			if (StringUtils.isBlank(proveedor.getNombre())) 
				return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
			Proveedor newProveedor = proveedorService.addProveedor(proveedor);
			return new ResponseEntity<>(newProveedor, HttpStatus.CREATED);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Proveedor> updateProveedor(@RequestBody Proveedor proveedor) {
		if (StringUtils.isBlank(proveedor.getNombre())) 
			return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Proveedor updateProveedor = proveedorService.updateProveedor(proveedor);
		return new ResponseEntity<>(updateProveedor, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProveedor(@PathVariable("id") Long id) {
		proveedorService.deleteProveedor(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
