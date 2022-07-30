package com.backend.peluqueriaback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_proveedor;
	private String nombre;
	private String descripcion;
}
