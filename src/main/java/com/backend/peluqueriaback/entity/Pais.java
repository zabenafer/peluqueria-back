package com.backend.peluqueriaback.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "pais")
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pais;
	private String nombre;
	
	//@JsonIgnoreProperties("pais")
	//@OneToMany(mappedBy = "pais")
	//private Set<Provincia> provincias = new HashSet<>();

}
