package com.backend.peluqueriaback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.peluqueriaback.entity.Localidad;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long>{
	
	Optional<Localidad> findById(Long id_localidad);

}
