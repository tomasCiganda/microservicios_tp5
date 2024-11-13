package com.microservicios.facultad.clients;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservicios.facultad.dto.InscriptosResponseDto;

import jakarta.websocket.server.PathParam;


@FeignClient(name = "alumnos")
public interface AlumnosClient {
    @GetMapping("api/alumnos/alumnoCarrera/{idCarrera}")
    InscriptosResponseDto getCantidadAlumnosByCarreraId(@PathVariable("idCarrera") int idCarrera);
}
