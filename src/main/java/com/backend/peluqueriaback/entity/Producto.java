package com.backend.peluqueriaback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;
	private String nombre;
	private int cantidad;
	private float precio;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

}
