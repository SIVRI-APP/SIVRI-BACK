package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface GrupoDisciplinaActualizarCU {
    Respuesta<Boolean> actualizar(long idGrupoDisciplina, int disciplinaId);
}
