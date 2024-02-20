package edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface SemilleroProgramaActualizarCU {
    Respuesta<Boolean> actualizar(long idSemilleroPrograma,int programaId);
}
