package com.backend.peluqueriaback.controller;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
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
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.peluqueriaback.dto.Mensaje;
import com.backend.peluqueriaback.entity.Cliente;
import com.backend.peluqueriaback.service.ClienteService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Cliente>> getAllClientes() {
		List<Cliente> clientes = clienteService.findAllCliente();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id) {
		if(!clienteService.existsById(id))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		Cliente cliente = clienteService.findClienteById(id);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/findname/{nombre}")
	public ResponseEntity<List<Cliente>> getByNombre(@PathVariable("nombre") String nombre) {
		if(!clienteService.existsByNombre(nombre))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		List<Cliente> clientes = clienteService.getByNombre(nombre);
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
	
	@GetMapping("/findclienteslocalidad/{id}")
	public ResponseEntity<List<Cliente>> getClientesByProvincia(@PathVariable("id") Long id) {
		List<Cliente> clientes = clienteService.findClientesByLocalidad(id);
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
		try {
			if (StringUtils.isBlank(cliente.getNombre()) || StringUtils.isBlank(cliente.getApellido()) || Objects.isNull(cliente.getLocalidad().getId_localidad())) 
				return new ResponseEntity(new Mensaje("Faltan campos de completar"), HttpStatus.BAD_REQUEST);
			Cliente newCliente = clienteService.addCliente(cliente);
			return new ResponseEntity<>(newCliente, HttpStatus.CREATED);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
	
	@PutMapping("/update")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
		Cliente updateCliente = clienteService.updateCliente(cliente);
		return new ResponseEntity<>(updateCliente, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable("id") Long id) {
		clienteService.deleteCliente(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
