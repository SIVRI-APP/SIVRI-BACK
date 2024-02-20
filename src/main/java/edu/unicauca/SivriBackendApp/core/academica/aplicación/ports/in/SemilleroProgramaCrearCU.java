package edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface SemilleroProgramaCrearCU {
    Respuesta<Boolean> crear(int semilleroId,int programaId);

}
