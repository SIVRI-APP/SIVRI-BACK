package edu.unicauca.SivriBackendApp.core.semillero.application.dto.request;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.EstadoIntegranteSemillero;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IntegranteSemilleroActualizarDTO {
    @NotNull(message = "El id del integrante del semillero es necesario para su actualización")
    private Integer id;

    private EstadoIntegranteSemillero estado;
    @NotNull(message = "El semestre del integrante es necesario para su actualización")
    private String semestre;
    private LocalDate fechaRetiro;
    @NotNull(message = "El rol del integrante del semillero es necesario para su actualización")
    private Integer rolSemilleroId;
}
