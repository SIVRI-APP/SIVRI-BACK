package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.respuesta;

import lombok.Data;

@Data
public class EvidenciaActividadDTO {
    private Integer id;
    private Integer actividadId;
    private String evidencia;
}
