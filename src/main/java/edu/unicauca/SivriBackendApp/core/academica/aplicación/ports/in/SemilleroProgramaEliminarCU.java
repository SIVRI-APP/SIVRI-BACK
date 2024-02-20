package edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface SemilleroProgramaEliminarCU {
    Respuesta<Boolean> eliminacionSemilleroProgramaFisico(long id);

}
