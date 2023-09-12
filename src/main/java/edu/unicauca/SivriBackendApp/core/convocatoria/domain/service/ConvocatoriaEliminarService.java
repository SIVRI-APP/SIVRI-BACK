package edu.unicauca.SivriBackendApp.core.convocatoria.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;

import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaActualizarCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaEliminarCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaObtenerCU;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ConvocatoriaEliminarService implements ConvocatoriaEliminarCU {

    private final ConvocatoriaActualizarCU convocatoriaActualizarCU;
    private final ConvocatoriaObtenerCU convocatoriaObtenerCU;

    public ConvocatoriaEliminarService(ConvocatoriaActualizarCU convocatoriaActualizarCU, ConvocatoriaObtenerCU convocatoriaObtenerCU) {
        this.convocatoriaActualizarCU = convocatoriaActualizarCU;
        this.convocatoriaObtenerCU = convocatoriaObtenerCU;
    }

    @Override
    public Respuesta<Boolean> eliminadoLogico(long id) {

        Convocatoria objetoParaEliminadoLogico = convocatoriaObtenerCU.obtenerPorId(id).getData();
        objetoParaEliminadoLogico.setEliminadoLogico(true);

        Boolean respuesta = convocatoriaActualizarCU.actualizar(objetoParaEliminadoLogico).getData();

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.eliminacion.objeto", List.of("Convocatoria", "Id", String.valueOf(id)));
        }
        System.out.println("Sali al service");
        return new RespuestaHandler<>(200, "Eliminación exitosa", "Eliminación Lógica", true).getRespuesta();
    }
}
