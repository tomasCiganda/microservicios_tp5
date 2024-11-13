package com.microservicios.alumnos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.JoinColumnOrFormula;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "alumno_carrera")
public class AlumnoCarrera implements Serializable {
    
    @EmbeddedId
    private AlumnoCarreraPK alumnoCarreraPK;

    @ManyToOne
    @MapsId("nroLibreta") // Mapea la clave foránea nroLibreta
    @JoinColumn(name="alumno_nro_libreta")
    private Alumno alumno;

    @Column(nullable = false, name="anio_inscripcion")
    private int anioInscripcion;

    @Column(nullable = false)
    private boolean finalizada;

}
