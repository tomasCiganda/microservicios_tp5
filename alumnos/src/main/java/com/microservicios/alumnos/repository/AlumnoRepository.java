package com.microservicios.alumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicios.alumnos.entity.Alumno;

@Repository
public interface  AlumnoRepository extends JpaRepository<Alumno, Long> {

}
