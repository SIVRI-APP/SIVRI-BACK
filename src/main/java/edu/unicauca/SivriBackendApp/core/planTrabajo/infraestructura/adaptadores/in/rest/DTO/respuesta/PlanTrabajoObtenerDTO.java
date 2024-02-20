package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EstadoPlanTrabajo;
import lombok.Data;

@Data
public class PlanTrabajoObtenerDTO {
    private int id;
    private Integer semilleroId;
    private EstadoPlanTrabajo estado;
    private String nombrePlan;

}
