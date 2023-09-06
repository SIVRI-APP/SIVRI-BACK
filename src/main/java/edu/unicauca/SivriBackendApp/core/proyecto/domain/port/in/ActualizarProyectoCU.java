package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;

public interface ActualizarProyectoCU {
    Respuesta<Boolean> actualizarProyecto(Proyecto proyecto);
}
