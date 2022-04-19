package com.backend.peluqueriaback.security.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.backend.peluqueriaback.security.enums.RolNombre;

import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Enumerated(EnumType.STRING)
	private RolNombre rolNombre;
	
	public Rol() {
		
	}
	public Rol(@NotNull RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}

}
