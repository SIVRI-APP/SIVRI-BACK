package edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;

public interface ConvocatoriaCrearCU {
    Respuesta<Boolean> crear(Convocatoria nuevosDatos);
}
