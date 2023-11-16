package edu.unicauca.SivriBackendApp.core.grupo.application.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IntegranteGrupoCrearDTO {

    @NotNull(message = "el numero de documento no puede ser nulo.")
    private String numeroDocumento;
    @NotNull(message = "debe seleccionar un rol para un integrante de un grupo.")
    private Integer rolGrupoId;
    @NotNull(message = "el integrante debe estar asociado a un grupo")
    private Integer grupoId;
}
