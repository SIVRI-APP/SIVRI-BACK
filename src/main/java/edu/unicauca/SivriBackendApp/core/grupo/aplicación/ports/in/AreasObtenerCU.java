package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Area;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.SubArea;

import java.util.List;

public interface AreasObtenerCU {
    Respuesta<Area> obtenerAreaPorId(int id);
    Respuesta<List<Area>> obtenerAreas();

    Respuesta<List<SubArea>> obtenerSubAreasPorIdArea(int id);
}
