package edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;

import java.util.List;

public interface ConvocatoriaObtenerCU {
    Respuesta<Boolean> existePorId(long id);
    Respuesta<Convocatoria> obtenerPorId(long id);
    Respuesta<List<Convocatoria>> obtenerListado();
}
