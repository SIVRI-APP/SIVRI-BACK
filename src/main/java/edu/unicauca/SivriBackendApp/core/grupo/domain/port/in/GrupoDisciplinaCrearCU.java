package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;

public interface GrupoDisciplinaCrearCU {
    Respuesta<Boolean> crear(int grupoId, int disciplinaId);
}
