package com.microservicios.alumnos.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.microservicios.alumnos.clients.FacultadClient;
import com.microservicios.alumnos.dto.AlumnoDto;
import com.microservicios.alumnos.dto.CarreraDto;
import com.microservicios.alumnos.dto.InscriptosResponseDto;
import com.microservicios.alumnos.entity.Alumno;
import com.microservicios.alumnos.entity.AlumnoCarrera;
import com.microservicios.alumnos.entity.AlumnoCarreraPK;
import com.microservicios.alumnos.mapper.AlumnoMapper;
import com.microservicios.alumnos.repository.AlumnoCarreraRepository;
import com.microservicios.alumnos.repository.AlumnoRepository;
import com.microservicios.alumnos.service.IAlumnoService;

import jakarta.persistence.Tuple;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private AlumnoCarreraRepository alumnoCarreraRepository;
    @Autowired
    private AlumnoMapper mapper;
    @Autowired
    private FacultadClient facultadClient;

    @Override
    public AlumnoDto addAlumno(AlumnoDto alumno) {
        try {
            Alumno alum = mapper.toEntity(alumno);
            alum = alumnoRepository.save(alum);
            return mapper.toDto(alum);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public AlumnoDto updateAlumno(AlumnoDto alumno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatAlumno'");
    }

    @Override
    public AlumnoDto getAlumno(long id) {
        return mapper.toDto(alumnoRepository.findById(id).get());
    }

    @Override
    public List<AlumnoDto> getAlumnos(String sortBy) {
        return mapper.toDtoList(alumnoRepository.findAll(Sort.by(sortBy).ascending()));
    }

    @Override
    public List<AlumnoDto> getAlumnosByFilter(String nombre, String apellido, Date fechaNacimiento, Integer dni,
            String genero) {
        return mapper.toDtoList(alumnoRepository.findByFilters(nombre, apellido, fechaNacimiento, dni, genero));
    }

    @Override
    public void deleteAlumno(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAlumno'");
    }


    @Override
    public void matricularAlumno(Long alumnoId, String nombreCarrera) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("nombre", nombreCarrera);
        CarreraDto carrera = facultadClient.getCarreraByNombre(queryParams);

        Alumno alumno = alumnoRepository.findById(alumnoId).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));;
        
        AlumnoCarreraPK pk = new AlumnoCarreraPK();
        pk.setIdCarrera(carrera.getIdCarrera());
        pk.setNroLibreta(alumnoId);
        System.out.println(carrera.getIdCarrera());
        AlumnoCarrera alumnoCarrera = new AlumnoCarrera();
        alumnoCarrera.setAlumnoCarreraPK(pk);
        alumnoCarrera.setAlumno(alumno);
        alumnoCarrera.setAnioInscripcion(LocalDate.now().getYear());
        alumnoCarrera.setFinalizada(false);
        
        alumnoCarreraRepository.save(alumnoCarrera);

    }

    @Override
    public InscriptosResponseDto cantidadAlumnosInscriptos(int idCarrera) {
        List<Object[]> tupla = alumnoCarreraRepository.inscriptosByCarrera(idCarrera);
        if (tupla.isEmpty()) {
            return new InscriptosResponseDto(idCarrera, 0);    
        }
        return new InscriptosResponseDto(idCarrera, (long)tupla.getFirst()[1]);
    }
}
