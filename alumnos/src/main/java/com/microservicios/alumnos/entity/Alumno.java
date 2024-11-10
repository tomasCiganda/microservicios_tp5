package com.microservicios.alumnos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Alumno")
public class Alumno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nroLibreta;

    @Column(unique = true, nullable = false)
	private long dni;

	@Column(nullable = false)
	private String nombre;

    @Column(nullable = false)
	private String apellido;

    @Column(nullable = false)
	private Date fechaNacimiento;

	@Column(nullable = false)
	private String genero;

	@OneToMany
	@JoinColumn(name = "nroLibreta")
	private List<AlumnoCarrera> alumnoCarrera;

}
