package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada;

import lombok.Data;


@Data
public class CrearProyectoDTO {

    private String nombre;

    private Integer organismoDeInvestigacionId;

    private Long directorDeProyectoId;

}
