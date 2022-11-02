package com.backend.peluqueriaback.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.peluqueriaback.dto.ReporteTurnoxMes;
import com.backend.peluqueriaback.dto.ReporteTurnoxTratamiento;
import com.backend.peluqueriaback.entity.Turno;
import com.backend.peluqueriaback.repository.TurnoRepository;

@Service
public class TurnoService {
	
	@Autowired
	TurnoRepository turnoRepository;
	
	public List<Turno> findAllTurno(){
		return turnoRepository.findTurnoByOrderFecha();
	}
	
	public List<Turno> findByNombreTratamiento(String nombre){
		return turnoRepository.findByNombreTratamiento(nombre);
	}
	
	public List<Turno> findByTurnoXCliente(Long id){
		return turnoRepository.findByTurnoXCliente(id);
	}	
	
	public List<Turno> findTurnosByCliente(Long id) {
		List<Turno> turnosResp = new ArrayList<>();
		List<Turno> turnos = turnoRepository.findAll();
		for (int i = 0; i < turnos.size(); i++) {
			if (turnos.get(i).getCliente().getId_cliente() == id) {
				turnosResp.add(turnos.get(i));
			}
			
		}
		return turnosResp;
	}
	
	public Turno addTurno(Turno turno) {
		return turnoRepository.save(turno);
	}
	
	public Turno updateTurno(Turno turno) {
		return turnoRepository.save(turno);
	}
	
	public void deleteTurno(Long id) {
		turnoRepository.deleteById(id);
	}
	
	public List<Turno> findTurnosByTratamiento(Long id) {
		List<Turno> turnosResp = new ArrayList<>();
		List<Turno> turnos = turnoRepository.findAll();
		for (int i = 0; i < turnos.size(); i++) {
			if (turnos.get(i).getTratamiento().getId_tratamiento() == id) {
				turnosResp.add(turnos.get(i));
			}			
		}
		return turnosResp;
	}
	
	public List<ReporteTurnoxTratamiento> FindCantTurnosXTratamiento(){
		return turnoRepository.ReporteCantTurnosXTratamiento();
	}
	
	public List<ReporteTurnoxMes> FindCantTurnosXMes(){
		return turnoRepository.ReporteCantTurnosXMes();
	}

}
