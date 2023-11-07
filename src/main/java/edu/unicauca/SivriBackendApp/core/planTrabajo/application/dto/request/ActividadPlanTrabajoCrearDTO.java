package edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ActividadPlanTrabajoCrearDTO {
    @NotEmpty(message = "Objetivo no puede ser nulo.")
    @NotBlank(message = "Dato Invalido")
    private String objetivo;
    @NotEmpty(message = "Actividad no puede ser nulo.")
    @NotBlank(message = "Dato Invalido")
    private String actividad;
    @NotNull(message = "Dato Invalido")
    private Integer idCompromiso;
    private String responsableUsuarioId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
