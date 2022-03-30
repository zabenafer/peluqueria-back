package com.backend.peluqueriaback.dto;

import lombok.Data;

@Data
public class TurnoDto {
	public TurnoDto(String fechaTurno, int precio, Long id_tratamiento, Long id_cliente) {
		this.fechaTurno = fechaTurno;
		this.precio = precio;
		this.id_tratamiento = id_tratamiento;
		this.id_cliente = id_cliente;
	}
	private String id_turno;
	private String fechaTurno;
	private int precio;
	private Long id_tratamiento;
	private Long id_cliente;

}
