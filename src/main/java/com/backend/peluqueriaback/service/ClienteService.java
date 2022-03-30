package com.backend.peluqueriaback.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.peluqueriaback.entity.Cliente;
import com.backend.peluqueriaback.exception.UserNotFoundException;
import com.backend.peluqueriaback.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> findAllCliente(){
		return clienteRepository.findAll();
	}
	
	public Cliente findClienteById(Long id_cliente) {
		return clienteRepository.findById(id_cliente).orElseThrow(() -> new UserNotFoundException("user"));
	}
	
	public List<Cliente> getByNombre(String nombre) {
		return clienteRepository.findByNombreContaining(nombre);
	}
	
	public Cliente addCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente updateCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public boolean existsById(Long id_cliente) {
		return clienteRepository.existsById(id_cliente);
	}

	public List<Cliente> findClientesByLocalidad(Long id) {
		List<Cliente> clientesResp = new ArrayList<>();
		List<Cliente> clientes = clienteRepository.findAll();
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getLocalidad().getId_localidad() == id) {
				clientesResp.add(clientes.get(i));
			}
			
		}
		return clientesResp;
	}
	
	public boolean existsByNombre(String nombre) {
		return clienteRepository.existsByNombre(nombre);
	}

}
