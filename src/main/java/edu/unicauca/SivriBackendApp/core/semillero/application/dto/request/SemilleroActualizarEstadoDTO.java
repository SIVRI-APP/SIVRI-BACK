package edu.unicauca.SivriBackendApp.core.semillero.application.dto.request;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.SemilleroEstado;
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
