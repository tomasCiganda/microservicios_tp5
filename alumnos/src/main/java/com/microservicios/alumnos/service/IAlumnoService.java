package com.microservicios.alumnos.service;

import java.util.Date;
import java.util.List;

import com.microservicios.alumnos.dto.AlumnoDto;
import com.microservicios.alumnos.dto.InscriptosResponseDto;

public interface IAlumnoService {
    
    AlumnoDto addAlumno(AlumnoDto alumno);

    AlumnoDto updateAlumno(AlumnoDto alumno);

    AlumnoDto getAlumno(long id);
    
    List<AlumnoDto> getAlumnos(String sortBy);
    
    List<AlumnoDto> getAlumnosByFilter(String nombre, String apellido, Date fechaNacimiento, Integer dni, String genero);

    void deleteAlumno(long id);

    void matricularAlumno(Long alumnoId, String nombreCarrera);

    InscriptosResponseDto cantidadAlumnosInscriptos(int idCarrera);
    
}
