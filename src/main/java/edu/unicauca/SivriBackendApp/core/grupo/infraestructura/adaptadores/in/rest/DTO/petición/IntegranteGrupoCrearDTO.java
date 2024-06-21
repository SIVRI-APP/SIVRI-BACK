package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IntegranteGrupoCrearDTO {

    @NotNull(message = "el numero de documento no puede ser nulo.")
    private String numeroDocumento;
    @NotNull(message = "debe seleccionar un rol para un integrante de un grupo.")
    private Integer rolGrupoId;
    @NotNull(message = "el integrante debe estar asociado a un grupo")
    private Integer grupoId;
}
