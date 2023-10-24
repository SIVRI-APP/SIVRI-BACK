package edu.unicauca.SivriBackendApp.core.usuario.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RolUsuario {

    Long id;

    Boolean estado;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private Usuario usuario;

    private RolAcademico rolAcademico;
}
