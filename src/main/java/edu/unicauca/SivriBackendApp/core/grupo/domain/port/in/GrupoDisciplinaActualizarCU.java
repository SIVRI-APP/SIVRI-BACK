package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface GrupoDisciplinaActualizarCU {
    Respuesta<Boolean> actualizar(long idGrupoDisciplina, int disciplinaId);
}
