package com.microservicios.alumnos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Embeddable
public class AlumnoCarreraPK implements Serializable{

    private Integer nroLibreta;
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
