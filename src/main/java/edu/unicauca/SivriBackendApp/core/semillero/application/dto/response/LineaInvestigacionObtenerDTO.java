package edu.unicauca.SivriBackendApp.core.semillero.application.dto.response;

import lombok.Data;

@Data
public class LineaInvestigacionObtenerDTO {
    private Integer id;
    private String linea;
    private Integer semilleroId;
}
