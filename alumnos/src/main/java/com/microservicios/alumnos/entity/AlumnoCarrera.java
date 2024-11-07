package com.microservicios.alumnos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name = "AlumnoCarrera")
public class AlumnoCarrera implements Serializable {
    
    @EmbeddedId
    private AlumnoCarreraPK alumnoCarreraPK;

    @ManyToOne
    @MapsId("idCarrera") // Mapea la clave foránea idCarrera
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;

    @ManyToOne
    @MapsId("nroLibreta") // Mapea la clave foránea nroLibreta
    @JoinColumn(name = "nroLibreta")
    private Alumno alumno;

    @Column(nullable = false)
    private int anioInscripcion;

    @Column(nullable = false)
    private boolean finalizada;

}
