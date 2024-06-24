package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface SemilleroProgramaEliminarCU {
    Respuesta<Boolean> eliminacionSemilleroProgramaFisico(long id);

}
