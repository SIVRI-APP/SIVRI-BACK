package edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.request;

import edu.unicauca.SivriBackendApp.core.semillero.application.dto.response.SemilleroObtenerDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlanTrabajoCrearDTO {
    @NotNull(message = "El nombre del plan de trabajo no puede ser Nulo")
    private String nombrePlan;
    private Integer semilleroId;

}
