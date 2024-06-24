package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;

public interface IntegranteSemilleroCrearCU {
    Respuesta<Boolean> crear(IntegranteSemillero nuevosIntegranteSemillero);

}
