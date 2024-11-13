package com.microservicios.alumnos.dto;

import lombok.Value;

@Value
public class InscriptosResponseDto {
    private long idCarrera;
    private long cantInscriptos;
}
