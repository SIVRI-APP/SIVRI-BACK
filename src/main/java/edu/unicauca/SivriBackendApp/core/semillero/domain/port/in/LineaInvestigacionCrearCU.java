package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;

public interface LineaInvestigacionCrearCU {
    Respuesta<Boolean> crear(int idSemillero,LineaInvestigacion nuevaLinea);

}
