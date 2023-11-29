package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface ProyectoEliminarCU {
    Respuesta<Boolean> eliminadoLogico(long id);
}
