package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;

public interface ProyectoActualizarREPO {
    Boolean actualizar(Proyecto nuevosDatos);
}
