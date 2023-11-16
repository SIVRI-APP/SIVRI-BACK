package edu.unicauca.SivriBackendApp.core.semillero.domain.model;

import lombok.Data;

@Data
public class LineaInvestigacion {
    private Integer id;
    private String linea;
    private Integer semilleroId;

}
