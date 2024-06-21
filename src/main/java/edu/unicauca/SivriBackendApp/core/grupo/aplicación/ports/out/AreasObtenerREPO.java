package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Area;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.SubArea;

import java.util.List;
import java.util.Optional;

public interface AreasObtenerREPO {
    List<Area> obtenerAreas();

    Optional<Area> obtenerAreaPorId(int id);

    List<SubArea> obtenerSubAreaPorIdArea(int idArea);
}
