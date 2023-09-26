package edu.unicauca.SivriBackendApp.core.proyecto.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class RolProyecto {

    private Integer id;

    private String nombre;

    private List<IntegranteProyecto> integrantesProyectos;
}
