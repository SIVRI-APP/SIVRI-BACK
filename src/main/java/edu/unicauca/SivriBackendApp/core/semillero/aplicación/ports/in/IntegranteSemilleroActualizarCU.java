package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;

public interface IntegranteSemilleroActualizarCU {
    Respuesta<Boolean> actualizar(IntegranteSemillero nuevosDatosIntegrante);
}
