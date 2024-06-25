package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;


public interface RolObtenerCU {

    Respuesta<RolProyecto> obtenerRolPorId(int rolId);
}
