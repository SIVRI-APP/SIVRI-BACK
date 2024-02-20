package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta;

import lombok.Data;

@Data
public class LineaInvestigacionObtenerDTO {
    private Integer id;
    private String linea;
    private Integer semilleroId;
}
