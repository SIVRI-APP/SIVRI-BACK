package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.SubArea;

import java.util.List;

public interface AreasObtenerCU {
    Respuesta<Area> obtenerAreaPorId(int id);
    Respuesta<List<Area>> obtenerAreas();

    Respuesta<List<SubArea>> obtenerSubAreasPorIdArea(int id);
}
