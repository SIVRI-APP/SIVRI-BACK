package edu.unicauca.SivriBackendApp.core.academica.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface SemilleroProgramaEliminarCU {
    Respuesta<Boolean> eliminacionSemilleroProgramaFisico(long id);

}
