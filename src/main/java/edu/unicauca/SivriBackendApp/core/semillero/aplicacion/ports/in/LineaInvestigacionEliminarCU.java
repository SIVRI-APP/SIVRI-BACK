package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface LineaInvestigacionEliminarCU {
    Respuesta<Boolean> eliminadoFisico(int id);
}
