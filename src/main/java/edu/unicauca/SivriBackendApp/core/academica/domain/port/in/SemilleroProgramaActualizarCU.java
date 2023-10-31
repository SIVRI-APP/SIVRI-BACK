package edu.unicauca.SivriBackendApp.core.academica.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;

public interface SemilleroProgramaActualizarCU {
    Respuesta<Boolean> actualizar(long idSemilleroPrograma,int programaId);
}
