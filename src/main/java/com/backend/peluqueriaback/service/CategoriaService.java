package com.backend.peluqueriaback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.peluqueriaback.entity.Categoria;
import com.backend.peluqueriaback.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAllCategoria(){
		return categoriaRepository.findAll();
	}
	
	public Categoria addCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria updateCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public void deleteCategoria(Long id) {
		categoriaRepository.deleteById(id);
	}
	
}
