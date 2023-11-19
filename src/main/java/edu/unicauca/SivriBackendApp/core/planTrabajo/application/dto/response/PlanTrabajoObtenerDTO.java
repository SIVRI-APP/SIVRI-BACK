package edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.response;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.EstadoPlanTrabajo;
import lombok.Data;

@Data
public class PlanTrabajoObtenerDTO {
    private int id;
    private Integer semilleroId;
    private EstadoPlanTrabajo estado;
    private String nombrePlan;

}
