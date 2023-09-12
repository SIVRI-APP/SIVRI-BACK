package edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;

import java.util.List;
import java.util.Optional;

public interface ObtenerConvocatoriaREPO {
    Boolean existePorId(long id);
    Optional<Convocatoria> obtenerPorId(long id);
    List<Convocatoria> obtenerListado();
}
