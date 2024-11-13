package com.microservicios.alumnos.clients;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservicios.alumnos.dto.CarreraDto;


@FeignClient(name = "facultad")
public interface FacultadClient {
    @GetMapping("api/facultad/helloFacultad")
    String getHelloFromFacultad();

    @GetMapping("api/facultad/search")
    CarreraDto getCarreraByNombre(@RequestParam Map<String, String> queryParams);
}
