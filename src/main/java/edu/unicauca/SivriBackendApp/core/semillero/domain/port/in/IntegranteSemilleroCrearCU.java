package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;

public interface IntegranteSemilleroCrearCU {
    Respuesta<Boolean> crear(IntegranteSemillero nuevosIntegranteSemillero);
}
