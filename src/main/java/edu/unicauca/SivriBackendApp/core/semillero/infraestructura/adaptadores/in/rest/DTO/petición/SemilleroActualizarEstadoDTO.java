package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SemilleroActualizarEstadoDTO {

    @NotNull(message = "el estado no puede ser nulo.")
    @NotEmpty(message = "el estado no puede ser nulo.")
    @Enumerated(EnumType.STRING)
    private String estado;


}
