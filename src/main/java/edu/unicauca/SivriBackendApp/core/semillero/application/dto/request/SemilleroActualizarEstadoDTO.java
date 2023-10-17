package edu.unicauca.SivriBackendApp.core.semillero.application.dto.request;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.SemilleroEstado;
import lombok.Data;

@Data
public class SemilleroActualizarEstadoDTO {
    private SemilleroEstado estado;

}
