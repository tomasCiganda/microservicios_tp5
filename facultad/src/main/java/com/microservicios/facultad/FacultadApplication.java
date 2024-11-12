package com.microservicios.facultad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.microservicios.facultad.mapper", "com.microservicios.facultad.controller"})
@EnableFeignClients
public class FacultadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacultadApplication.class, args);
	}

}
