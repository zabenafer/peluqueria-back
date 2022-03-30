package com.backend.peluqueriaback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.peluqueriaback.entity.Provincia;
import com.backend.peluqueriaback.repository.ProvinciaRepository;

@Service
public class ProvinciaService {
	
	@Autowired
	ProvinciaRepository provinciaRepository;
	
	public List<Provincia> findAllProvincias(){
		return provinciaRepository.findAll();
	}

}
