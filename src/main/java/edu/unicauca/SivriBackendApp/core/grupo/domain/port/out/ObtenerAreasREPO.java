package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;

import java.util.List;
import java.util.Optional;

public interface ObtenerAreasREPO {
    List<Area> obtenerAreas();

    Optional<Area> obtenerAreaPorId(int id);
}
