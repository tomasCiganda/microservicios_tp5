package com.microservicios.alumnos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservicios.alumnos.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
    @Query(value = "SELECT * FROM alumno a WHERE " +
           "(:nombre IS NULL OR a.nombre = :nombre) AND " +
           "(:apellido IS NULL OR a.apellido = :apellido) AND "+
           "(:fecha IS NULL OR a.fecha_nacimiento = :fecha) AND " +
           "(:dni IS NULL OR a.dni = :dni) AND " +
           "(:genero IS NULL OR a.genero = :genero)" , nativeQuery=true)
    List<Alumno> findByFilters(@Param("nombre") String nombre, 
                               @Param("apellido") String apellido,
                               @Param("fecha") Date fechaNacimiento,
                               @Param("dni") Integer dni,
                               @Param("genero") String genero);
}
