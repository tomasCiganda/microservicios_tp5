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
@Table(name = "Carrera")
public class Carrera implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarrera;

    @Column(unique = true)
    private String nombreCarrera;

    @OneToMany
    @JoinColumn(name = "idCarrera")
    private List<AlumnoCarrera> alumnoCarrera;

    @Override
    public String toString() {
        return "Carrera{" +
                "idCarrera=" + idCarrera +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                ", cantidadAlumnos=" + (alumnoCarrera != null ? alumnoCarrera.size() : 0) +
                '}';
    }


}
