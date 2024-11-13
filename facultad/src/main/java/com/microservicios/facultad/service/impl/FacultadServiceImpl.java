package com.microservicios.facultad.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.facultad.clients.AlumnosClient;
import com.microservicios.facultad.dto.CarreraDto;
import com.microservicios.facultad.dto.InscriptosResponseDto;
import com.microservicios.facultad.entity.Carrera;
import com.microservicios.facultad.mapper.CarreraMapper;
import com.microservicios.facultad.repository.CarreraRepository;
import com.microservicios.facultad.service.IFacultadService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class FacultadServiceImpl implements IFacultadService {

    @Autowired
    private CarreraRepository repository;

    @Autowired
    private CarreraMapper mapper;

    @Autowired
    private AlumnosClient alumnoClient;

    @Override
    public List<CarreraDto> getCarreras() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public CarreraDto getCarrera(long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public CarreraDto getCarreraByNombre(String nombreCarrera) {
        Carrera entity = repository.findByNombreCarrera(nombreCarrera);
        return mapper.toDto(entity);
    }

    @Override
    public List<InscriptosResponseDto> getCarrerasOrderByCantInscriptos() {
        List<Carrera> carreras = repository.findAll();
        List<InscriptosResponseDto> carrerasConInscriptos = new ArrayList<>();
        for (Carrera elem : carreras) {
            InscriptosResponseDto cants = alumnoClient.getCantidadAlumnosByCarreraId(elem.getIdCarrera()); 
            if (cants.getCantInscriptos()>0) {
                cants.setNombre(elem.getNombreCarrera());
                carrerasConInscriptos.add(cants);
            }
        }

        carrerasConInscriptos = carrerasConInscriptos.stream().sorted(Comparator.comparing(InscriptosResponseDto::getCantInscriptos)).collect(Collectors.toList());
        
        return carrerasConInscriptos;
    }

    

}
