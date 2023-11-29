package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;

public interface IntegranteGrupoCrearCU {

    Respuesta<Boolean> asociarIntegranteGrupo(IntegranteGrupo nuevosDatos);
}
