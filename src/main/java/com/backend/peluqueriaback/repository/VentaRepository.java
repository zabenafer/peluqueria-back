package com.backend.peluqueriaback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.peluqueriaback.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
	
}
