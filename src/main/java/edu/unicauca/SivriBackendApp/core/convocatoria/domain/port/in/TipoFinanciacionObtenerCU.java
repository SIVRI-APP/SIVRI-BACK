package edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.TipoFinanciacion;

import java.util.List;
import java.util.Optional;

public interface TipoFinanciacionObtenerCU {
    Respuesta<Boolean> existePorId(long id);
    Respuesta<TipoFinanciacion> obtenerPorId(long id);
    Respuesta<List<TipoFinanciacion>> obtenerListado();
}
