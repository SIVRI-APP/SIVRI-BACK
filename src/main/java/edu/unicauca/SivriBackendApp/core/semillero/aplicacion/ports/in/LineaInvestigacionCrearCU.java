package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;

public interface LineaInvestigacionCrearCU {
    Respuesta<Boolean> crear(LineaInvestigacion nuevaLinea);

}
