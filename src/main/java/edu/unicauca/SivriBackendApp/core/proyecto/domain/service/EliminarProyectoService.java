package edu.unicauca.SivriBackendApp.core.proyecto.domain.service;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.inbound.EliminarProyectoCasoUso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EliminarProyectoService implements EliminarProyectoCasoUso {
    @Override
    public Respuesta eliminarProyecto(int id) {
        return null;
    }
}
