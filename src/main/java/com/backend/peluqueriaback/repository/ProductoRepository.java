package com.backend.peluqueriaback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.peluqueriaback.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>  {

}
