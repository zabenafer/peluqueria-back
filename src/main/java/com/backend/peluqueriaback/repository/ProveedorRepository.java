package com.backend.peluqueriaback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.peluqueriaback.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{

}
