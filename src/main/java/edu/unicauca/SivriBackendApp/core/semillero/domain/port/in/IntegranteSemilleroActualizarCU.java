package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;

public interface IntegranteSemilleroActualizarCU {
    Respuesta<Boolean> actualizar(IntegranteSemillero nuevosDatosIntegrante);
}