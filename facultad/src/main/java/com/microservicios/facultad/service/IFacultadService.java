package com.microservicios.facultad.service;

import java.util.List;

import com.microservicios.facultad.dto.CarreraDto;
import com.microservicios.facultad.dto.InscriptosResponseDto;

public interface IFacultadService {

    public List<CarreraDto> getCarreras();
    public CarreraDto getCarrera(long id);
    public CarreraDto getCarreraByNombre(String nombreCarrera);
    public List<InscriptosResponseDto> getCarrerasOrderByCantInscriptos();

}
