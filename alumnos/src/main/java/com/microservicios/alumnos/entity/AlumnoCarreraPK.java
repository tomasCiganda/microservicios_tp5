package com.microservicios.alumnos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
@Embeddable
public class AlumnoCarreraPK implements Serializable{

    @Column(name = "alumno_nro_libreta")
    private Long nroLibreta;
    @Column(name = "id_carrera")
    private Integer idCarrera;

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlumnoCarreraPK)) return false;
        AlumnoCarreraPK that = (AlumnoCarreraPK) o;
        return idCarrera == that.idCarrera && nroLibreta == that.nroLibreta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCarrera, nroLibreta);
    }
}
