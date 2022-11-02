package com.backend.peluqueriaback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.peluqueriaback.entity.Cliente;
import com.backend.peluqueriaback.entity.Producto;
import com.backend.peluqueriaback.exception.UserNotFoundException;
import com.backend.peluqueriaback.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	public List<Producto> findAllProducto(){
		return productoRepository.findAll();
	}
	
	public Producto findProductoById(Long id_producto) {
		return productoRepository.findById(id_producto).orElseThrow(() -> new UserNotFoundException("user"));
	}
	
	public Producto addProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public Producto updateProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public void deleteProducto(Long id) {
		productoRepository.deleteById(id);
	}

}
