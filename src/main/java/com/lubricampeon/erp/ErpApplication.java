package com.lubricampeon.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class ErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://localhost:3000"));
		configuration.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept",
				"Access-Control-Allow-Origin", "Jwt-Token", "Authorization", "Origin-Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		configuration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept",
				"Access-Control-Allow-Origin", "Jwt-Token", "Authorization", "Origin-Accept",
				"Access-Control-Allow-Credentials", "Fielname"));
		configuration.setAllowedMethods(Arrays.asList("POST","GET","PUT","PATCH","DELETE","OPTIONS"));
		source.registerCorsConfiguration("/**", configuration);
		return new CorsFilter(source);
	}

}
