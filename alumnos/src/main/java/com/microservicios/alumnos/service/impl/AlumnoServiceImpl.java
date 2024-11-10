package com.microservicios.alumnos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.alumnos.dto.AlumnoDto;
import com.microservicios.alumnos.mapper.AlumnoMapper;
import com.microservicios.alumnos.repository.AlumnoRepository;
import com.microservicios.alumnos.service.AlumnoService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository repository;
    
    @Autowired
    private AlumnoMapper mapper;

    @Override
    public AlumnoDto addAlumno(AlumnoDto alumno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAlumno'");
    }

    @Override
    public AlumnoDto updatAlumno(AlumnoDto alumno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatAlumno'");
    }

    @Override
    public AlumnoDto getAlumno(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAlumno'");
    }

    @Override
    public List<AlumnoDto> getAlumnos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAlumnos'");
    }

    @Override
    public void deleteAlumno(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAlumno'");
    }

}
