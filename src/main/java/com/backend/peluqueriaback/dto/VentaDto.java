package com.backend.peluqueriaback.dto;

import java.io.Serializable;
import java.util.List;

import com.backend.peluqueriaback.entity.DetalleVenta;

import lombok.Data;

@Data
public class VentaDto implements Serializable {
	
	public VentaDto(String cod_venta, String descripcion, float monto_total, Long id_cliente, List<DetalleVentaDto> detalleVenta) {
		this.cod_venta = cod_venta;
		this.descripcion = descripcion;
		this.monto_total = monto_total;
		this.id_cliente = id_cliente;
		this.detalleVenta = detalleVenta;
	}
	
	private String cod_venta;
	private String descripcion;
	private float monto_total;
	private Long id_cliente;
	private List<DetalleVentaDto> detalleVenta;

}
