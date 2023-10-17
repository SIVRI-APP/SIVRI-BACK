package edu.unicauca.SivriBackendApp.core.academica.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.Facultad;

import java.util.List;

public interface FacultadObtenerCU {
    Respuesta<Boolean> existePorId(Integer id);
    Respuesta<Facultad> obtenerPorId(Integer id);

    Respuesta<List<Facultad>> obtenerFacultades();

}
