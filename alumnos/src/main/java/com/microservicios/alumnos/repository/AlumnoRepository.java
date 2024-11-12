package com.microservicios.alumnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservicios.alumnos.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
    @Query("SELECT a FROM alumno a WHERE " +
           "(:nombre IS NULL OR a.nombre = :nombre) AND " +
           "(:apellido IS NULL OR a.apellido = :apellido) AND " +
           "(:edad IS NULL OR a.edad = :edad)")
    List<Alumno> findByFilters(@Param("nombre") String nombre, 
                               @Param("apellido") String apellido, 
                               @Param("edad") Integer edad);
}
