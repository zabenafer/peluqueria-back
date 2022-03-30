package com.backend.peluqueriaback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.peluqueriaback.entity.Localidad;
import com.backend.peluqueriaback.service.LocalidadService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/localidad")
public class LocalidadController {
	
	@Autowired
	LocalidadService localidadService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Localidad>> getAllLocalidad() {
		List<Localidad> localidades = localidadService.findAllLocalidad();
		return new ResponseEntity<List<Localidad>>(localidades, HttpStatus.OK);
	}
	
	@GetMapping("/findlocalidadxprovincia/{id}")
	public ResponseEntity<List<Localidad>> getAllLocalidadByProvincia(@PathVariable("id") Long idProvincia) {
		List<Localidad> localidades = localidadService.findAllLocalidadByProvincia(idProvincia);
		return new ResponseEntity<List<Localidad>>(localidades, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Localidad> addLocalidad(@RequestBody Localidad localidad) {
		try {			
			Localidad newLocalidad = localidadService.addLocalidad(localidad);
			return new ResponseEntity<>(newLocalidad, HttpStatus.CREATED);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
