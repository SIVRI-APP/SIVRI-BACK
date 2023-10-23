package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;

public interface LineaInvestigacionActualizarCU {
    Respuesta<Boolean> actualizarLinea(int idLinea,LineaInvestigacion nuevaLinea);
}
