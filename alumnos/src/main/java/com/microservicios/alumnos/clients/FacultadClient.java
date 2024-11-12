package com.microservicios.alumnos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "facultad")
public interface FacultadClient {
    @GetMapping("api/facultad/helloFacultad")
    String getHelloFromFacultad();
}
