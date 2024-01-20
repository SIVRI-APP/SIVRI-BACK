package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;

import java.util.List;

public interface LineaInvestigacionObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<LineaInvestigacion> obtenerPorId(int id);
    Respuesta<List<LineaInvestigacion>> obtenerLineasInvestigacionPorSemilleroId(int idSemillero);
    Respuesta<List<LineaInvestigacion>> obtenerListadoLineasInvestigacion();
}
