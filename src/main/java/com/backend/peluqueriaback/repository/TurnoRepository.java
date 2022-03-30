package com.backend.peluqueriaback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.peluqueriaback.entity.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
	
	@Query(value = "SELECT * FROM turno INNER JOIN tratamiento on tratamiento.id_tratamiento = turno.id_tratamiento where tratamiento.nombre = :nombre", nativeQuery = true)
	List<Turno> findByNombreTratamiento(@Param(value="nombre") String nombre);

}
