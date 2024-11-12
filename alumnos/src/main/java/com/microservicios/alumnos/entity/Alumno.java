package com.microservicios.alumnos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Alumno")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nroLibreta")
    private long nroLibreta;

    @Column(unique = true, nullable = false, name = "dni")
    private long dni;

    @Column(nullable = false, name = "nombre")
    private String nombre;

    @Column(nullable = false, name = "apellido")
    private String apellido;

    @Column(nullable = false, name = "fechaNacimiento")
    private Date fechaNacimiento;

    @Column(nullable = false, name = "genero")
    private String genero;

    @Column(nullable = false, name = "direccion")
    private String direccion;

    @OneToMany
    @JoinColumn(name = "nroLibreta")
    private List<AlumnoCarrera> alumnoCarrera;

}
