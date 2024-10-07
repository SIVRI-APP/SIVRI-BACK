package edu.unicauca.SivriBackendApp.core.academica.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;

import java.util.List;

public interface FacultadObtenerCU {
    Respuesta<Boolean> existePorId(Integer id);
    Respuesta<Facultad> obtenerPorId(Integer id);
    Respuesta<List<Facultad>> obtenerFacultades();

}
