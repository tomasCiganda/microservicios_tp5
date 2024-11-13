package com.microservicios.alumnos.dto;

import lombok.Value;

@Value
public class MatricularRequestDto {
    private Long nroLibreta;
    private String nombreCarrera;
}
