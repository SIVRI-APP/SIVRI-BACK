package edu.unicauca.SivriBackendApp.core.academica.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;

public interface SemilleroProgramaCrearCU {
    Respuesta<Boolean> crear(int semilleroId,int programaId);

}
