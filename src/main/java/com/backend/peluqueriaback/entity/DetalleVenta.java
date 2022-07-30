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
@Table(name = "detalleVenta")
public class DetalleVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_detalleVenta;
	private String cantidad;
	private float precio;
	
	@ManyToOne()
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	@ManyToOne()
	@JoinColumn(name = "id_venta")
	private Venta venta;

}
