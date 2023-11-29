package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.CompromisoSemillero;

import java.util.List;

public interface CompromisoSemilleroObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<CompromisoSemillero> obtenerPorId(int id);
    Respuesta<List<CompromisoSemillero>> obtenerListadoCompromisos();
}
