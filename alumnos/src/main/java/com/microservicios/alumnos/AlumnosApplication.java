package com.microservicios.alumnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages="com.microservicios.alumnos")
@EnableFeignClients
public class AlumnosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlumnosApplication.class, args);
    }

}
