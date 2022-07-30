package com.backend.peluqueriaback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.peluqueriaback.entity.Proveedor;
import com.backend.peluqueriaback.repository.ProveedorRepository;

@Service
public class ProveedorService {

	@Autowired
	ProveedorRepository proveedorRepository;
	
	public List<Proveedor> findAllProveedor(){
		return proveedorRepository.findAll();
	}
	
	public Proveedor addProveedor(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}
	
	public Proveedor updateProveedor(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}
	
	public void deleteProveedor(Long id) {
		proveedorRepository.deleteById(id);
	}
	
}
