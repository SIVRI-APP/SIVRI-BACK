package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface GrupoDisciplinaCrearCU {
    Respuesta<Boolean> crear(int grupoId, int disciplinaId);
}
