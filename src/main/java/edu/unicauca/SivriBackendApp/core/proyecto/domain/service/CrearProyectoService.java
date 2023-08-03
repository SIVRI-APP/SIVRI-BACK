package edu.unicauca.SivriBackendApp.core.proyecto.domain.service;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.inbound.CrearProyectoCasoUso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrearProyectoService implements CrearProyectoCasoUso {
    @Override
    public Respuesta crearProyecto(Proyecto proyecto) {
        return null;
    }
}
