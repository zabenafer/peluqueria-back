package com.backend.peluqueriaback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.peluqueriaback.entity.DetalleVenta;


@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
	
}
