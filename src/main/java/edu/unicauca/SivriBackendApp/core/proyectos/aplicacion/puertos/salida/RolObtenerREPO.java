package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;

import java.util.Optional;

public interface RolObtenerREPO {

    Optional<RolProyecto> obtenerProyectoPorId (long proyectoId);
    Optional<RolProyecto> obtenerRolPorEnum (RolProyectoEnum proyectoId);
}
