package org.generation.fyndr;

import org.generation.fyndr.seguridad.JwtFilter;
import org.generation.fyndr.seguridad.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FyndrApplication {

	public static void main(String[] args) {
		SpringApplication.run(FyndrApplication.class, args);
	} // main

	@Bean
	public FilterRegistrationBean<JwtFilter> filterRegistrationBean(JwtUtil jwtUtil) {
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter(jwtUtil));
		
		// Registrar endpoints protegidos
		registrationBean.addUrlPatterns("/api/usuarios-comunes/*");
		registrationBean.addUrlPatterns("/api/usuarios-trabajadores/*");
		registrationBean.addUrlPatterns("/api/contrataciones/*");
		registrationBean.addUrlPatterns("/api/mensajes/*");
		registrationBean.addUrlPatterns("/api/profesiones/*");
		registrationBean.addUrlPatterns("/api/publicaciones/*");
		registrationBean.addUrlPatterns("/api/resenas/*");
		registrationBean.addUrlPatterns("/api/auth/*");
		registrationBean.addUrlPatterns("/api/favoritos/*");
		
		return registrationBean;
	} // filterRegistrationBean
} // class FyndrApplication
