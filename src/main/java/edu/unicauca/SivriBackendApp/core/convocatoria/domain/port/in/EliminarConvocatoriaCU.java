package edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;

public interface EliminarConvocatoriaCU {
    Respuesta<Boolean> eliminadoLogico(long id);
}
