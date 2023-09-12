package edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;

public interface ConvocatoriaActualizarREPO {
    Boolean actualizar(Convocatoria nuevosDatos);
}
