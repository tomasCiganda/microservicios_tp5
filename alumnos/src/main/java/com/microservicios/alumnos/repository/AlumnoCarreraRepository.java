package com.microservicios.alumnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservicios.alumnos.entity.AlumnoCarrera;
import com.microservicios.alumnos.entity.AlumnoCarreraPK;

import jakarta.persistence.Tuple;

@Repository
public interface AlumnoCarreraRepository extends JpaRepository<AlumnoCarrera, AlumnoCarreraPK> {
    // Consulta SQL nativa para contar registros agrupados por 'genero'
    @Query(value="SELECT id_carrera , COUNT(*) FROM alumno_carrera  WHERE id_carrera = :carreraId GROUP BY id_carrera", nativeQuery=true)
    List<Object[]> inscriptosByCarrera(@Param("carreraId") long carreraId);
}
