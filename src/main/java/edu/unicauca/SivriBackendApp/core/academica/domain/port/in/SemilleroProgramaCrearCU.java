package edu.unicauca.SivriBackendApp.core.academica.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface SemilleroProgramaCrearCU {
    Respuesta<Boolean> crear(int semilleroId,int programaId);

}
