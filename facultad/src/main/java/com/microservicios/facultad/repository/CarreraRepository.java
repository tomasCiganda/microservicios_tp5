package com.microservicios.facultad.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicios.facultad.entity.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    Carrera findByNombreCarrera(String nombreCarrera);
}
