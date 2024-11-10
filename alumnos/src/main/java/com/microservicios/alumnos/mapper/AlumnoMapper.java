package com.microservicios.alumnos.mapper;

import org.mapstruct.Mapper;

import com.microservicios.alumnos.dto.AlumnoDto;
import com.microservicios.alumnos.entity.Alumno;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {

    AlumnoDto toDto(Alumno alumno);

    Alumno toAlumno(AlumnoDto alumnoDto);
}
