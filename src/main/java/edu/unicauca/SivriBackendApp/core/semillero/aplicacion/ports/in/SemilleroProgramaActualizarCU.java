package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface SemilleroProgramaActualizarCU {
    Respuesta<Boolean> actualizar(long idSemilleroPrograma,int programaId);
}
