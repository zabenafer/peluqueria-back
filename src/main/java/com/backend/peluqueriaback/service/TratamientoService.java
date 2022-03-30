package com.backend.peluqueriaback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.peluqueriaback.entity.Tratamiento;
import com.backend.peluqueriaback.repository.TratamientoRepository;

@Service
public class TratamientoService {
	
	@Autowired
	TratamientoRepository tratamientoRepository;
	
	public List<Tratamiento> findAllTratamiento(){
		return tratamientoRepository.findAll();
	}
	
	public Tratamiento addTratamiento(Tratamiento tratamiento) {
		return tratamientoRepository.save(tratamiento);
	}
	
	public Tratamiento updateTratamiento(Tratamiento tratamiento) {
		return tratamientoRepository.save(tratamiento);
	}
	
	public void deleteTratamiento(Long id) {
		tratamientoRepository.deleteById(id);
	}

}
