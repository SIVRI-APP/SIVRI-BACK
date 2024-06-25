package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos;

import lombok.*;

import java.util.Set;

@Data
public class RolProyecto {

    private Integer id;

    private String nombre;

    private Set<IntegranteProyecto> integrantesProyectos;
}
