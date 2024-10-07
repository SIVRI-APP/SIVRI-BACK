package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.RolProyectoListarProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;

import java.util.List;

public interface RolObtenerCU {

    Respuesta<RolProyecto> obtenerRolPorId(int rolId);
    Respuesta<RolProyecto> obtenerRolPorEnum(RolProyectoEnum rolId);
    Respuesta<List<RolProyectoListarProyeccion>> retornarRoles (TipoUsuario tipoUsuario);
}
