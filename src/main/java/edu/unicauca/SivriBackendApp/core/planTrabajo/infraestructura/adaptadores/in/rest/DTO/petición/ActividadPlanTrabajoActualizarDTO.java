package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ActividadPlanTrabajoActualizarDTO {
    @NotBlank(message = "Dato invalido")
    private String objetivo;
    @NotBlank(message = "Dato invalido")
    private String actividad;
    @NotNull(message = "Dato invalido")

    private LocalDate fechaInicio;
    @NotNull(message = "Dato invalido")
    private LocalDate fechaFin;
    @NotNull(message = "Dato Invalido")
    private Integer idCompromiso;
    @NotBlank(message = "Dato invalido")
    private String responsableUsuarioId;
}
