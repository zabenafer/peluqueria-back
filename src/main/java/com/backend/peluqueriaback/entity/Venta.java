package com.backend.peluqueriaback.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_venta;
	private Long cod_venta;
	private String descripcion;
	private float monto_total;
	
	@OneToMany(mappedBy = "id_venta")
	private List<DetalleVenta> detalleVenta;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;	
	

}
