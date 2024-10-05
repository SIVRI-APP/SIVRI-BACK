package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos;

import lombok.Data;

@Data
public class LineaInvestigacion {
    private Integer id;
    private String linea;
    private Integer semillero_Id;
}
