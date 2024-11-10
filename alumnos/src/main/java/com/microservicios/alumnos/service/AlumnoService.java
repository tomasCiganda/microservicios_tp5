package com.microservicios.alumnos.service;

import java.util.List;

import com.microservicios.alumnos.dto.AlumnoDto;

public interface AlumnoService {
    
    AlumnoDto addAlumno(AlumnoDto alumno);

    AlumnoDto updatAlumno(AlumnoDto alumno);

    AlumnoDto getAlumno(long id);
    
    List<AlumnoDto> getAlumnos();

    void deleteAlumno(long id);
    
}
