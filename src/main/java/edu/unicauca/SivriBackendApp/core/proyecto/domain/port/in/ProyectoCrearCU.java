package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;

public interface ProyectoCrearCU {
    Respuesta<Boolean> crear(Proyecto nuevosDatos);
}
