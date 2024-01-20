package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;

import java.util.List;
import java.util.Optional;

public interface LineaInvestigacionObtenerREPO {
    Boolean existePorId(int id);
    Optional<LineaInvestigacion> obtenerPorId(int id);
    List<LineaInvestigacion> obtenerLineasInvestigacionPorSemilleroId(int idSemillero);
    List<LineaInvestigacion> obtenerListadoLineasInvestigacion();
}
