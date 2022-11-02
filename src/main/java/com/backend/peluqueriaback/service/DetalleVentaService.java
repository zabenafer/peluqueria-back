package com.backend.peluqueriaback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.peluqueriaback.entity.DetalleVenta;
import com.backend.peluqueriaback.repository.DetalleVentaRepository;

@Service
public class DetalleVentaService {

	@Autowired
	DetalleVentaRepository detalleVentaRepository;
	
	public List<DetalleVenta> findAllDetalleVenta(){
		return detalleVentaRepository.findAll();
	}
	
	
	public DetalleVenta updateDetalleVenta(DetalleVenta detalleVenta) {
		return detalleVentaRepository.save(detalleVenta);
	}
	
	public void deleteDetalleVenta(Long id) {
		detalleVentaRepository.deleteById(id);
	}
	
	public List<DetalleVenta> findByDetalleVentaXVenta(Long id){
		return detalleVentaRepository.findByDetalleVentaXVenta(id);
	}
	
}
