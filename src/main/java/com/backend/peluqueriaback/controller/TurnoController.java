package com.backend.peluqueriaback.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.backend.peluqueriaback.entity.Turno;
import com.backend.peluqueriaback.service.TurnoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/turno")
public class TurnoController {
	
	@Autowired
	TurnoService turnoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Turno>> getAllTurnos() {
		List<Turno> turnos = turnoService.findAllTurno();
		return new ResponseEntity<List<Turno>>(turnos, HttpStatus.OK);
	}
	
	@GetMapping("/findturnosxclientes/{id}")
	public ResponseEntity<List<Turno>> getAllTurnosByClientes(@PathVariable("id") Long idCliente) {
		List<Turno> turnos = turnoService.findByTurnoXCliente(idCliente);
		return new ResponseEntity<List<Turno>>(turnos, HttpStatus.OK);
	}
	
	@GetMapping("/findturnosxtratamiento/{id}")
	public ResponseEntity<List<Turno>> getAllTurnosByTratamiento(@PathVariable("id") Long idTratamiento) {
		List<Turno> turnos = turnoService.findTurnosByTratamiento(idTratamiento);
		return new ResponseEntity<List<Turno>>(turnos, HttpStatus.OK);
	}
	
	@GetMapping("/findturnosxtratamientonombre/{nombre}")
	public ResponseEntity<List<Turno>> getTurnosByNombreTratamiento(@PathVariable("nombre") String nombre) {
		List<Turno> turnos = turnoService.findByNombreTratamiento(nombre);
		return new ResponseEntity<List<Turno>>(turnos, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Turno> addTurno(@RequestBody Turno turno) {
		try {
			if (Objects.isNull(turno.getFecha_turno()))
				return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);					
			if (turno.getPrecio() <= 0) 
				return new ResponseEntity(new Mensaje("El Precio es obligatorio"), HttpStatus.BAD_REQUEST);
			if (Objects.isNull(turno.getTratamiento().getId_tratamiento()))
				return new ResponseEntity(new Mensaje("El tratamiento es obligatorio"), HttpStatus.BAD_REQUEST);
			if (Objects.isNull(turno.getCliente().getId_cliente()))
				return new ResponseEntity(new Mensaje("El cliente es obligatorio"), HttpStatus.BAD_REQUEST);
			Turno newTurno = turnoService.addTurno(turno);
			return new ResponseEntity<>(newTurno, HttpStatus.CREATED);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Turno> updateTurno(@RequestBody Turno turno) {
		if (turno.getPrecio() <= 0) 
			return new ResponseEntity(new Mensaje("El Precio es obligatorio"), HttpStatus.BAD_REQUEST);
		Turno updateTurno = turnoService.updateTurno(turno);
		return new ResponseEntity<>(updateTurno, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTurno(@PathVariable("id") Long id) {
		turnoService.deleteTurno(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
