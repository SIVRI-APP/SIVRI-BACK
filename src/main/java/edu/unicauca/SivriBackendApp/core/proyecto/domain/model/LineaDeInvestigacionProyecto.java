package edu.unicauca.SivriBackendApp.core.proyecto.domain.model;

import lombok.Data;

@Data
public class LineaDeInvestigacionProyecto {

    private Integer id;

    private String nombre;

    private Proyecto proyecto;
}
