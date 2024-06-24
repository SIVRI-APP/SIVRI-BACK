package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface SemilleroProgramaCrearCU {
    Respuesta<Boolean> crear(int semilleroId,int programaId);

}
