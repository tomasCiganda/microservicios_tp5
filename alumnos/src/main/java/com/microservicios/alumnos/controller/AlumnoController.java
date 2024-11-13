package com.microservicios.alumnos.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.alumnos.dto.AlumnoDto;
import com.microservicios.alumnos.dto.InscriptosResponseDto;
import com.microservicios.alumnos.dto.MatricularRequestDto;
import com.microservicios.alumnos.service.impl.AlumnoServiceImpl;




@RestController
@RequestMapping(value="/api/alumnos")
public class AlumnoController {

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

    @GetMapping("")
    public ResponseEntity<List<AlumnoDto>> getAll(@RequestParam(defaultValue = "nombre") String sortBy) {
        return ResponseEntity.ok(alumnoService.getAlumnos(sortBy));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(alumnoService.getAlumno(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<AlumnoDto>> searchAlumnos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) Date fechaNacimiento,
            @RequestParam(required = false) Integer dni,
            @RequestParam(required = false) String genero) {
        
        List<AlumnoDto> alumnos = alumnoService.getAlumnosByFilter(nombre, apellido, fechaNacimiento, dni, genero);
        return ResponseEntity.ok(alumnos);
    }

    @PostMapping("/matricular")
    public ResponseEntity<Void> matricular(@RequestBody MatricularRequestDto entity) {
        
        alumnoService.matricularAlumno(entity.getNroLibreta(), entity.getNombreCarrera());
        return ResponseEntity.ok().build();
    }

    @GetMapping("alumnoCarrera/{idCarrera}")
    public ResponseEntity<InscriptosResponseDto> cantidadAlumnosInscriptos(@PathVariable int idCarrera) {
        return ResponseEntity.ok(alumnoService.cantidadAlumnosInscriptos(idCarrera));
    }

    
    

}
