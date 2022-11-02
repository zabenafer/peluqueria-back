package com.backend.peluqueriaback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.peluqueriaback.dto.ReporteTurnoxMes;
import com.backend.peluqueriaback.dto.ReporteTurnoxTratamiento;
import com.backend.peluqueriaback.entity.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
	
	@Query(value = "SELECT * FROM turno INNER JOIN tratamiento on tratamiento.id_tratamiento = turno.id_tratamiento where tratamiento.nombre = :nombre", nativeQuery = true)
	List<Turno> findByNombreTratamiento(@Param(value="nombre") String nombre);
	
	@Query(value = "SELECT * FROM turno INNER JOIN cliente on cliente.id_cliente = turno.id_cliente where cliente.id_cliente = :id_cliente order by fecha_turno asc", nativeQuery = true)
	List<Turno> findByTurnoXCliente(@Param(value="id_cliente") Long id_cliente);
	
	@Query(value = "SELECT * FROM turno order by fecha_turno asc", nativeQuery=true)
	List<Turno> findTurnoByOrderFecha();
	
	@Query(value = "SELECT COUNT(id_turno) as Cantidad, tratamiento.id_tratamiento, tratamiento.nombre FROM turno INNER join tratamiento on tratamiento.id_tratamiento = turno.id_tratamiento group by tratamiento.id_tratamiento", nativeQuery=true)
	List<ReporteTurnoxTratamiento> ReporteCantTurnosXTratamiento();
	
	@Query(value = "SELECT MONTHNAME(t.fecha_turno) AS Mes,\r\n" + 
			"COUNT(t.id_turno) AS Cantidad\r\n" + 
			"FROM turno t\r\n" + 
			"WHERE YEAR(t.fecha_turno) = '2022'\r\n" + 
			"GROUP BY Mes\r\n" + 
			"ORDER BY Mes ASC;", nativeQuery=true)
	List<ReporteTurnoxMes> ReporteCantTurnosXMes();

}
