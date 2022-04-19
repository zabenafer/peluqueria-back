package com.backend.peluqueriaback.security.jwt;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {
	//Esta clase se va a ejecutar por cada peticion. Va a comprobar que sea valido el token
	//La validez la hace utilizando la clase JwtProvider, en el caso que sea valido permite el acceso al recurso
	// en el caso contrario lanza la excepcion.
	
    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication;
        try {
            authentication = jwtProvider.authenticate(request);
            if(authentication != null)
                SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            log.info("fail en do filter ", e);
        }
        filterChain.doFilter(request, response);
    }
}
