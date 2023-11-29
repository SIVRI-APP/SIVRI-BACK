package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;

public interface LineaInvestigacionActualizarCU {
    Respuesta<Boolean> actualizarLinea(int idLinea,LineaInvestigacion nuevaLinea);
}
