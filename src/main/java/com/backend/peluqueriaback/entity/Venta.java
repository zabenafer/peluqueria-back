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
@Table(name = "venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_venta;
	private String cod_venta;
	private String descripcion;
	private float monto_total;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

}
