package com.backend.peluqueriaback.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.peluqueriaback.entity.Localidad;

import com.backend.peluqueriaback.repository.LocalidadRepository;

@Service
public class LocalidadService {
	
	@Autowired
	LocalidadRepository localidadRepository;
	
	public List<Localidad> findAllLocalidad(){
		return localidadRepository.findAll();
	}
	
	public List<Localidad> findAllLocalidadByProvincia(Long id) {
		List<Localidad> localidadResp = new ArrayList<>();
		List<Localidad> localidades = localidadRepository.findAll();
		for (int i = 0; i < localidades.size(); i++) {
			if (localidades.get(i).getProvincia().getId_provincia() == id) {
				localidadResp.add(localidades.get(i));
			}			
		}
		return localidadResp;
	}
	
	public Localidad addLocalidad(Localidad localidad) {
		return localidadRepository.save(localidad);
	}
	
	public Localidad updateLocalidad(Localidad localidad) {
		return localidadRepository.save(localidad);
	}
	
	public void deleteLocalidad(Long id) {
		localidadRepository.deleteById(id);
	}

}
