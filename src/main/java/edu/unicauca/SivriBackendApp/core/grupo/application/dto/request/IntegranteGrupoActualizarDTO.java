package edu.unicauca.SivriBackendApp.core.grupo.application.dto.request;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoEstado;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IntegranteGrupoActualizarDTO {
    @NotNull(message = "el id del integrante del grupo es necesario para la actualizacion")
    private int id;
    @NotNull(message = "el rol del integrante del grupo no puede ser nulo.")
    private Integer rolGrupoId;
    private EstadoIntegranteGrupo estado;
    private LocalDate fechaFin;

}
