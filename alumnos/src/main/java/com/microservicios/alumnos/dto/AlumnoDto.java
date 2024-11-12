package com.microservicios.alumnos.dto;

import java.util.Date;

import lombok.Value;

@Value
public class AlumnoDto {

    private long nroLibreta;

    private long dni;

    private String nombre;

    private String apellido;

    private Date fechaNacimiento;

    private String genero;

    private String direccion;
}
