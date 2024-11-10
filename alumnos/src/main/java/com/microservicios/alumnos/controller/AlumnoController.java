package com.microservicios.alumnos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.alumnos.dto.AlumnoDto;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping(value="/api/alumno")
public class AlumnoController {


    @PostMapping("")
    public AlumnoDto save(@RequestBody AlumnoDto request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

}
