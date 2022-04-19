package com.backend.peluqueriaback.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.peluqueriaback.security.entity.Rol;
import com.backend.peluqueriaback.security.enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
