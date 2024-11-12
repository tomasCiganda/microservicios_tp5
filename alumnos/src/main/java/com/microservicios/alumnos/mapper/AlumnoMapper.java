package com.microservicios.alumnos.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.microservicios.alumnos.dto.AlumnoDto;
import com.microservicios.alumnos.entity.Alumno;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {
    AlumnoDto toDto(Alumno alumno);
    List<AlumnoDto> toDtoList(List<Alumno> alumnos);

    Alumno toAlumno(AlumnoDto alumnoDto);

    
}
