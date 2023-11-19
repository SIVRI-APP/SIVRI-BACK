package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;

import java.util.List;

public interface LineaInvestigacionObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<LineaInvestigacion> obtenerPorId(int id);
    Respuesta<List<LineaInvestigacion>> obtenerLineasInvestigacionPorSemilleroId(int idSemillero);
    Respuesta<List<LineaInvestigacion>> obtenerListadoLineasInvestigacion();
}
