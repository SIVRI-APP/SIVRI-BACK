package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.inbound;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.RespuestaPaginada;

public interface ObtenerProyectosCasoUso {

    Respuesta obtenerProyectoPorId(int id);

    RespuestaPaginada obtenerProyectos();
}
