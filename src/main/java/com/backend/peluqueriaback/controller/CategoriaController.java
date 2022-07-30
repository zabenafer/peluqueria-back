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
import com.backend.peluqueriaback.entity.Categoria;
import com.backend.peluqueriaback.entity.Producto;
import com.backend.peluqueriaback.entity.Proveedor;
import com.backend.peluqueriaback.service.CategoriaService;
import com.backend.peluqueriaback.service.ProductoService;
import com.backend.peluqueriaback.service.ProveedorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Categoria>> getAllCategoria() {
		List<Categoria> categoria = categoriaService.findAllCategoria();
		return new ResponseEntity<List<Categoria>>(categoria, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria) {
		try {
			if (StringUtils.isBlank(categoria.getNombre())) 
				return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
			Categoria newCategoria = categoriaService.addCategoria(categoria);
			return new ResponseEntity<>(newCategoria, HttpStatus.CREATED);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria) {
		if (StringUtils.isBlank(categoria.getNombre())) 
			return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Categoria updateCategoria = categoriaService.updateCategoria(categoria);
		return new ResponseEntity<>(updateCategoria, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable("id") Long id) {
		categoriaService.deleteCategoria(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
