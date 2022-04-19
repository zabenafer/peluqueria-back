package com.backend.peluqueriaback;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.util.DefaultResourceRetriever;
import com.nimbusds.jose.util.ResourceRetriever;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;

@SpringBootApplication
public class PeluqueriaBackApplication {
	
	@Value("${com.backend.jwt.aws.connectionTimeout}")
	private int connectionTimeout;
	@Value("${com.backend.jwt.aws.readTimeout}")
	private int readTimeout;
	@Value("${com.backend.jwt.aws.jwkUrl}")
	private String jwkUrl;

	public static void main(String[] args) {
		SpringApplication.run(PeluqueriaBackApplication.class, args);
	}
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE").maxAge(3600);
            }
        };
    }
	@Bean
	public ConfigurableJWTProcessor configurableJWTProcessor() throws MalformedURLException {
		ResourceRetriever resourceRetriever = new DefaultResourceRetriever(connectionTimeout, readTimeout);
		URL jwkURL = new URL(jwkUrl);
		JWKSource jwkSource = new RemoteJWKSet<>(jwkURL, resourceRetriever);
		ConfigurableJWTProcessor jwtProcessor = new DefaultJWTProcessor();
		JWSKeySelector keySelector = new JWSVerificationKeySelector(JWSAlgorithm.RS256, jwkSource);
		jwtProcessor.setJWSKeySelector(keySelector);
		return jwtProcessor;
	}

}
