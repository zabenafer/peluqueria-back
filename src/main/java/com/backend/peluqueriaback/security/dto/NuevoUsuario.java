package com.backend.peluqueriaback.security.dto;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
public class NuevoUsuario {
	
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();
 
    
}
