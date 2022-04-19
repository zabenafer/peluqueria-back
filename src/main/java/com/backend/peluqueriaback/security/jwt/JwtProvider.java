package com.backend.peluqueriaback.security.jwt;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtProvider {
	//Esta clase genera el token, metodos de validacion que este bien formado y no expirado
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	private static final String USERNAME_FIELD = "username";
    private static final String BEARER = "Bearer ";
    private static final String AUTHORIZATION = "Authorization";

    @Value("${com.backend.jwt.aws.identityPoolUrl}")
    private String identityPoolUrl;

    @Autowired
    ConfigurableJWTProcessor configurableJWTProcessor;

    public Authentication authenticate(HttpServletRequest request) throws Exception {
        String token = request.getHeader(AUTHORIZATION);
        if (token != null) {
            JWTClaimsSet claims = configurableJWTProcessor.process(getToken(token), null);
            validateToken(claims);
            String username = getUsername(claims);
            if (username != null) {
                // TODO set roles
            	List<GrantedAuthority> authorities = new ArrayList<>();
            	authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            	//List.of(new SimpleGrantedAuthority("ROLE_USER"));
                User user = new User(username, "", authorities);
                return new JwtAuthenticator(authorities, user, claims);
            }
        }
        return null;
    }

    private String getUsername(JWTClaimsSet claims) {
        return claims.getClaim(USERNAME_FIELD).toString();
    }

    private void validateToken(JWTClaimsSet claims) throws Exception {
        if(!claims.getIssuer().equals(identityPoolUrl))
            throw new Exception("JWT not valid");
    }

    private String getToken(String token) {
        return token.startsWith(BEARER) ? token.substring(BEARER.length()) : token;
    }

}
