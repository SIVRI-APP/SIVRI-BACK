package edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface ConvocatoriaEliminarCU {
    Respuesta<Boolean> eliminadoLogico(long id);
}
