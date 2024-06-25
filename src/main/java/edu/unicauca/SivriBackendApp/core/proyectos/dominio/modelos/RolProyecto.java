package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;
import lombok.*;

import java.util.Set;

@Data
public class RolProyecto {

    private Integer id;

    private RolProyectoEnum nombre;

    private Set<IntegranteProyecto> integrantesProyectos;
}
