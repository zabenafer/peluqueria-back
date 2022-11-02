package com.backend.peluqueriaback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.peluqueriaback.dto.VentaDto;
import com.backend.peluqueriaback.entity.Turno;
import com.backend.peluqueriaback.entity.Venta;
import com.backend.peluqueriaback.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired
	VentaRepository ventaRepository;
	
	public List<Venta> findAllVenta(){
		return ventaRepository.findAll();
	}
	
	public Venta addVenta(Venta dto) {
		return ventaRepository.save(dto);
	}
	
	public Venta updateVenta(Venta venta) {
		return ventaRepository.save(venta);
	}
	
	public void deleteVenta(Long id) {
		ventaRepository.deleteById(id);
	}
	
	public List<Venta> findUltioCodigoVenta(){
		return ventaRepository.findUltimoCodVenta();
	}
	
}
