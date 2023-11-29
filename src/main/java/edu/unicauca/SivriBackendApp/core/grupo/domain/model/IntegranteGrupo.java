package edu.unicauca.SivriBackendApp.core.grupo.domain.model;

import lombok.*;

import java.time.LocalDate;

@Data
public class IntegranteGrupo {
    private Integer id;
    private EstadoIntegranteGrupo estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private RolGrupo rolGrupo;
    //TODO usuario
    //private Usuario usuario;
    private Grupo grupo;

}