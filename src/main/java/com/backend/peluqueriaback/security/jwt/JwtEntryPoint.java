package com.backend.peluqueriaback.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JwtEntryPoint implements AuthenticationEntryPoint{
	//Esta clase se fija si hay un token valido o no, en el caso que no devuelve
	// una respuesta 401 no autorizado. Rechaza las peticiones no autorizadas.

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("fail en método commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "unauthorized");
    }

}
