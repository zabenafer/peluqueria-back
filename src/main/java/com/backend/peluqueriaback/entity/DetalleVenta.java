package com.backend.peluqueriaback.entity;

import java.util.List;

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
	private int cantidad;
	private float precio;
	private Long id_venta;
	
	//@ManyToOne()
	//@JoinColumn(name = "id_producto")
	//private Producto producto;
	private Long id_producto;
	
	//@ManyToOne()
	//@JoinColumn(name = "id_venta")
	//private Venta venta;

}
