package edu.unicauca.SivriBackendApp.core.proyecto.domain.service;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.inbound.ActualizarProyectoCasoUso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActualizarProyectoService implements ActualizarProyectoCasoUso {
    @Override
    public Respuesta actualizarProyecto(Proyecto proyecto) {
        return null;
    }
}
