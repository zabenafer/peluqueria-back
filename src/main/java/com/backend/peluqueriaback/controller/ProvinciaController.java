package com.backend.peluqueriaback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.peluqueriaback.entity.Provincia;
import com.backend.peluqueriaback.service.ProvinciaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/provincia")
public class ProvinciaController {
	
	@Autowired
	ProvinciaService provinciaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Provincia>> getAllProvincias() {
		List<Provincia> provincias = provinciaService.findAllProvincias();
		return new ResponseEntity<List<Provincia>>(provincias, HttpStatus.OK);
	}

}
