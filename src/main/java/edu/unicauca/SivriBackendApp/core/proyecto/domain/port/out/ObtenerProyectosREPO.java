package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;


import java.util.List;
import java.util.Optional;

public interface ObtenerProyectosREPO {
    Optional<Proyecto> obtenerProyectoPorId(int id);
    List<Proyecto> obtenerProyectos();
}
