package com.backend.peluqueriaback.dto;

import lombok.Data;

@Data
public class Mensaje {
	
	private String mensaje;

	public Mensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

}
