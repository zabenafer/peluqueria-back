package com.backend.peluqueriaback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.peluqueriaback.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
}