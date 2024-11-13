package com.microservicios.facultad.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.microservicios.facultad.dto.CarreraDto;
import com.microservicios.facultad.entity.Carrera;

@Mapper(componentModel = "spring")
public interface CarreraMapper {
    CarreraDto toDto(Carrera alumno);
    List<CarreraDto> toDtoList(List<Carrera> alumnos);

    Carrera toEntity(CarreraDto alumnoDto);

}
