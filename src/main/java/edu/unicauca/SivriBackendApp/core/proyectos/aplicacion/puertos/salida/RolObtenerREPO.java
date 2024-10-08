package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.RolProyectoListarProyeccion;

import java.util.List;
import java.util.Optional;

public interface RolObtenerREPO {

    Optional<RolProyecto> obtenerProyectoPorId (long proyectoId);
    Optional<RolProyecto> obtenerRolPorEnum (RolProyectoEnum proyectoId);
    List<RolProyecto> findAll();
    List<RolProyectoListarProyeccion> retornarRoles ();
    boolean tieneDirector(long proyectoId);
}
