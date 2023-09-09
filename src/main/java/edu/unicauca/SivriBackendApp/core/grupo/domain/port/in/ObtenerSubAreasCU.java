package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.SubArea;

import java.util.List;

public interface ObtenerSubAreasCU {

    Respuesta<SubArea> obtenerSubAreaPorId(int id);

    Respuesta<List<SubArea>> obtenerSubAreas();
}
