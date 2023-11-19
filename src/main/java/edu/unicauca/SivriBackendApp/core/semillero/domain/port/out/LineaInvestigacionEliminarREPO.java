package edu.unicauca.SivriBackendApp.core.semillero.domain.port.out;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;

public interface LineaInvestigacionEliminarREPO {
    Boolean eliminadoFisico(LineaInvestigacion lineaEliminar);
    Boolean eliminadoFisicoLinea(int id);
}
