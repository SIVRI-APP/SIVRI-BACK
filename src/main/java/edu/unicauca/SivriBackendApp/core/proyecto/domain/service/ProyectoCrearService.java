package edu.unicauca.SivriBackendApp.core.proyecto.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ProyectoCrearCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.ProyectoCrearREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProyectoCrearService implements ProyectoCrearCU {

    private final ProyectoCrearREPO proyectoCrearREPO;

    public ProyectoCrearService(ProyectoCrearREPO proyectoCrearREPO) {
        this.proyectoCrearREPO = proyectoCrearREPO;
    }

    @Override
    public Respuesta<Boolean> crear(Proyecto nuevosDatos) {
        nuevosDatos.setEstado(EstadoProyecto.FORMULADO);
        Boolean respuesta = proyectoCrearREPO.crear(nuevosDatos);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Proyecto", "Id", String.valueOf(nuevosDatos.getId())));
        }

        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Proyecto"), "", true).getRespuesta();
    }
}
