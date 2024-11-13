package com.microservicios.facultad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.facultad.dto.CarreraDto;
import com.microservicios.facultad.dto.InscriptosResponseDto;
import com.microservicios.facultad.service.impl.FacultadServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/facultad")
public class FacultadController {
    @Autowired
    private FacultadServiceImpl service;

    @GetMapping("/helloFacultad")
    public String sayHello() {
        return "Hello, World! desde facultad";
    }

    @GetMapping("")
    public List<CarreraDto> getAllCarreras() {
        return service.getCarreras();
    }

    @GetMapping("/search")
    public CarreraDto getCarreraByNombre(
            @RequestParam(required = true) String nombre) {
        return service.getCarreraByNombre(nombre);
    }

    @GetMapping("/orderByInscriptos")
    public List<InscriptosResponseDto> getCarrerasOrderByCantInscriptos() {
        return service.getCarrerasOrderByCantInscriptos();
    }
    

}
