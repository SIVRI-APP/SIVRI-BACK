package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;

public interface IntegranteGrupoActualizarCU {
    Respuesta<Boolean> actualizar(IntegranteGrupo nuevosDatos);
}
