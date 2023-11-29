package edu.unicauca.SivriBackendApp.core.proyecto.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ProyectoActualizarCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ProyectoEliminarCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ProyectoObtenerCU;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProyectoEliminarService implements ProyectoEliminarCU {

    private final ProyectoActualizarCU proyectoActualizarCU;
    private final ProyectoObtenerCU proyectoObtenerCU;

    public ProyectoEliminarService(ProyectoActualizarCU proyectoActualizarCU, ProyectoObtenerCU proyectoObtenerCU) {
        this.proyectoActualizarCU = proyectoActualizarCU;
        this.proyectoObtenerCU = proyectoObtenerCU;
    }

    @Override
    public Respuesta<Boolean> eliminadoLogico(long id) {

        Proyecto objetoParaEliminadoLogico = proyectoObtenerCU.obtenerPorId(id).getData();
        objetoParaEliminadoLogico.setEliminadoLogico(true);

        Boolean respuesta = proyectoActualizarCU.actualizar(objetoParaEliminadoLogico).getData();

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.eliminacion.objeto", List.of("Proyecto", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "success.eliminacion.objeto", List.of("Proyecto"), "Eliminación Lógica", true).getRespuesta();
    }
}
