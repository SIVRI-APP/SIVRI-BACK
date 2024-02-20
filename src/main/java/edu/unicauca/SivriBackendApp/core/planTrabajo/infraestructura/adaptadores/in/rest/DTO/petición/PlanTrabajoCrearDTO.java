package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PlanTrabajoCrearDTO {
    @NotNull(message = "El nombre del plan de trabajo no puede ser Nulo")
    @NotEmpty(message = "El nombre del plan de trabajo no puede ser Nulo")
    @Size(min = 4,max = 45,message = "el  nombre del plan de trabajo debe estar entre 4 y 45 caracteres")
    private String nombrePlan;


}
