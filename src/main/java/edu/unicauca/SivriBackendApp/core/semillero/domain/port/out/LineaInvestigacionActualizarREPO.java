package edu.unicauca.SivriBackendApp.core.semillero.domain.port.out;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;

public interface LineaInvestigacionActualizarREPO {
    Boolean actualizarLinea(LineaInvestigacion nuevaLinea);
}
