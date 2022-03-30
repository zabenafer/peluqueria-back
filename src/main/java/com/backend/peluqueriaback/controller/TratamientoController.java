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
import com.backend.peluqueriaback.entity.Tratamiento;
import com.backend.peluqueriaback.service.TratamientoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tratamiento")
public class TratamientoController {
	
	@Autowired
	TratamientoService tratamientoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Tratamiento>> getAllTratamiento() {
		List<Tratamiento> tratamientos = tratamientoService.findAllTratamiento();
		return new ResponseEntity<List<Tratamiento>>(tratamientos, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Tratamiento> addTratamiento(@RequestBody Tratamiento tratamiento) {
		try {
			if (StringUtils.isBlank(tratamiento.getNombre())) 
				return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
			if (tratamiento.getPrecio() <= 0) 
				return new ResponseEntity(new Mensaje("El Precio es obligatorio"), HttpStatus.BAD_REQUEST);
			Tratamiento newTratamiento = tratamientoService.addTratamiento(tratamiento);
			return new ResponseEntity<>(newTratamiento, HttpStatus.CREATED);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
	
	@PutMapping("/update")
	public ResponseEntity<Tratamiento> updateTratamiento(@RequestBody Tratamiento tratamiento) {
		if (StringUtils.isBlank(tratamiento.getNombre())) 
			return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if (tratamiento.getPrecio() <= 0) 
			return new ResponseEntity(new Mensaje("El Precio es obligatorio"), HttpStatus.BAD_REQUEST);
		Tratamiento updateTratamiento = tratamientoService.updateTratamiento(tratamiento);
		return new ResponseEntity<>(updateTratamiento, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTratamiento(@PathVariable("id") Long id) {
		tratamientoService.deleteTratamiento(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
