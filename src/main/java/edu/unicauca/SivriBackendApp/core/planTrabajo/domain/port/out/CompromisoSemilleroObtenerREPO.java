package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.CompromisoSemillero;

import java.util.List;
import java.util.Optional;

public interface CompromisoSemilleroObtenerREPO {
    Boolean existePorId(int id);
    Optional<CompromisoSemillero> obtenerPorId(int id);
    List<CompromisoSemillero> obtenerListadoCompromisos();
}
