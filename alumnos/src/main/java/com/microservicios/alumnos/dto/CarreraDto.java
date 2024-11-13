package com.microservicios.alumnos.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Value;

@Value
public class CarreraDto {
    
    private Integer idCarrera;

    
    private String nombreCarrera;
}
