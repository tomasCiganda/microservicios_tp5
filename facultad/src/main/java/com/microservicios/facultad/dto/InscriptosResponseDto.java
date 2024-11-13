package com.microservicios.facultad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@AllArgsConstructor
public class InscriptosResponseDto {
    private long idCarrera;
    private long cantInscriptos;
    private String nombre;
}
