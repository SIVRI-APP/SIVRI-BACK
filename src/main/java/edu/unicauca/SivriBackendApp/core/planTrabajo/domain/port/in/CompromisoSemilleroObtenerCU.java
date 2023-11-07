package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.CompromisoSemillero;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;

import java.util.List;

public interface CompromisoSemilleroObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<CompromisoSemillero> obtenerPorId(int id);
    Respuesta<List<CompromisoSemillero>> obtenerListadoCompromisos();
}
