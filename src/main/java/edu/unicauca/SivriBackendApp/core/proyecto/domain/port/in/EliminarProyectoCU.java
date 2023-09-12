package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;

public interface EliminarProyectoCU {
    Respuesta<Boolean> eliminarProyecto (long id);
}
