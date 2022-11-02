package com.backend.peluqueriaback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.peluqueriaback.entity.DetalleVenta;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
	
	@Query(value = "SELECT * FROM detalle_venta INNER JOIN venta on venta.id_venta = detalle_venta.id_venta where detalle_venta.id_venta = :id_venta", nativeQuery = true)
	List<DetalleVenta> findByDetalleVentaXVenta(@Param(value="id_venta") Long id_venta);
	
}
