package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface GrupoDisciplinaCrearCU {
    Respuesta<Boolean> crear(int grupoId, int disciplinaId);
}
