package edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;

public interface ConvocatoriaEliminarCU {
    Respuesta<Boolean> eliminadoLogico(long id);
}
