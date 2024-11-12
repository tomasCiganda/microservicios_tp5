package com.microservicios.facultad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value="/api/facultad")
public class FacultadController {
    @GetMapping("/helloFacultad")
    public String sayHello() {
        return "Hello, World! desde facultad";
    }
}
