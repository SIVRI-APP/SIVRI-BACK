package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.SubArea;

import java.util.List;
import java.util.Optional;

public interface AreasObtenerREPO {
    List<Area> obtenerAreas();

    Optional<Area> obtenerAreaPorId(int id);

    List<SubArea> obtenerSubAreaPorIdArea(int idArea);
}
