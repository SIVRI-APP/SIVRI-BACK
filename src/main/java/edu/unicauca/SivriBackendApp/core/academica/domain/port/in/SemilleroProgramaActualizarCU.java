package edu.unicauca.SivriBackendApp.core.academica.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;

public interface SemilleroProgramaActualizarCU {
    Respuesta<Boolean> actualizar(long idSemilleroPrograma,int programaId);
}
