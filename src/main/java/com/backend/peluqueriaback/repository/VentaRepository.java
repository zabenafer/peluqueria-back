package com.backend.peluqueriaback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.peluqueriaback.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
	
	@Query(value = "SELECT * FROM Venta order by id_venta desc LIMIT 1", nativeQuery=true)
	List<Venta> findUltimoCodVenta();
	
}
