package com.backend.peluqueriaback.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.peluqueriaback.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Transactional(readOnly = true)
	List<Cliente> findByNombreContaining(String nombre);
	//boolean existsByNombre(String Nombre);
	Optional<Cliente> findById(Long id_cliente);
	boolean existsByNombre(String nombre);
}
