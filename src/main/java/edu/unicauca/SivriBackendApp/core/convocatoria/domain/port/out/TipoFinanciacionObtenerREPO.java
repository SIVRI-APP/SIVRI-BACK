package edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.TipoFinanciacion;

import java.util.List;
import java.util.Optional;

public interface TipoFinanciacionObtenerREPO {
    Boolean existePorId(long id);
    Optional<TipoFinanciacion> obtenerPorId(long id);
    List<TipoFinanciacion> obtenerListado();
}
