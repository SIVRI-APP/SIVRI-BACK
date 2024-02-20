package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;

public interface LineaInvestigacionActualizarCU {
    Respuesta<Boolean> actualizarLinea(int idLinea, LineaInvestigacion nuevaLinea);
}
