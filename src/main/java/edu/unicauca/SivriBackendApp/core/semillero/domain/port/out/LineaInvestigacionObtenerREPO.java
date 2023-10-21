package edu.unicauca.SivriBackendApp.core.semillero.domain.port.out;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;

import java.util.List;
import java.util.Optional;

public interface LineaInvestigacionObtenerREPO {
    Boolean existePorId(int id);
    Optional<LineaInvestigacion> obtenerPorId(int id);
    List<LineaInvestigacion> obtenerLineasInvestigacionPorSemilleroId(int idSemillero);
    List<LineaInvestigacion> obtenerListadoLineasInvestigacion();
}
