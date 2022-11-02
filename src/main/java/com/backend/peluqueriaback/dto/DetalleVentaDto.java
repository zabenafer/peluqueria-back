package com.backend.peluqueriaback.dto;
import com.backend.peluqueriaback.entity.Producto;
import lombok.Data;

@Data
public class DetalleVentaDto {
	
	public DetalleVentaDto(String cantidad, float precio, Long id_venta, Producto producto) {
		this.cantidad = cantidad;
		this.precio = precio;
		this.id_venta = id_venta;
		this.producto = producto;
	}
	
	private String cantidad;
	private float precio;
	private Long id_venta;
	
	private Producto producto;

}
