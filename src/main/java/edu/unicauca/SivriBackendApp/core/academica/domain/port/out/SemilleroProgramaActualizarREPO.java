package edu.unicauca.SivriBackendApp.core.academica.domain.port.out;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;

public interface SemilleroProgramaActualizarREPO {
    Boolean actualizar(SemilleroPrograma nuevosDatos);

}
