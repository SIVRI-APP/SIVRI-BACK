package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;

import java.util.List;

public interface ObtenerProyectosCU {
    Respuesta<Proyecto> obtenerProyectoPorId(int id);
    Respuesta<List<Proyecto>> obtenerProyectos();
}
