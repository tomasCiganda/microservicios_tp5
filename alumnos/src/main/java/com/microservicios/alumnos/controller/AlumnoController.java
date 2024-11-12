package com.microservicios.alumnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.alumnos.clients.FacultadClient;
import com.microservicios.alumnos.dto.AlumnoDto;
import com.microservicios.alumnos.service.impl.AlumnoServiceImpl;




@RestController
@RequestMapping(value="/api/alumnos")
public class AlumnoController {

    @Autowired
    private FacultadClient facultadClient;

    @Autowired
    private AlumnoServiceImpl alumnoService;

    @PostMapping("")
    public AlumnoDto save(@RequestBody AlumnoDto request) {
        return alumnoService.addAlumno(request);
    }

    @GetMapping("/helloAlumno")
    public String sayHello() {
        return "Hello, World! desde alumno";
    }

    @GetMapping("/helloFromFacultad")
    public String getHelloFromFacultad() {
        return facultadClient.getHelloFromFacultad();
    }

    @GetMapping("")
    public List<AlumnoDto> getAll() {
        return alumnoService.getAlumnos();
    }
    
    @GetMapping("/{id}")
    public AlumnoDto getById(@PathVariable long id) {
        return alumnoService.getAlumno(id);
    }
    

}
