package edu.unicauca.SivriBackendApp.core.proyecto.domain.service;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.RespuestaPaginada;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.inbound.ObtenerProyectosCasoUso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ObtenerProyectosService implements ObtenerProyectosCasoUso {
    @Override
    public Respuesta obtenerProyectoPorId(int id) {
        return null;
    }

    @Override
    public RespuestaPaginada obtenerProyectos() {
        return null;
    }
}
