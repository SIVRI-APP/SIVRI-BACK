package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PlanTrabajoActualizarDTO {
    @NotNull(message = "El nombre del plan de trabajo no puede ser Nulo")
    @NotEmpty(message = "El nombre del plan de trabajo no puede ser Nulo")
    @Size(min = 4,max = 45,message = "el  nombre del plan de trabajo debe estar entre 4 y 45 caracteres")
    private String nombrePlan;
    @NotNull(message = "el estado no puede ser nulo.")
    @NotEmpty(message = "el estado no puede ser nulo.")
    @Enumerated
    private String estado;
}
