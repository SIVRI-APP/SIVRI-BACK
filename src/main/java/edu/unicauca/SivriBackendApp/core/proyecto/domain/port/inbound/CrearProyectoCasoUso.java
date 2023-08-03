package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.inbound;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;

public interface CrearProyectoCasoUso {
    Respuesta crearProyecto(Proyecto proyecto);
}
