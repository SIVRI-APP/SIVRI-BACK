package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;

public interface LineaInvestigacionEliminarCU {
    Respuesta<Boolean> eliminadoFisico(int id);
}
