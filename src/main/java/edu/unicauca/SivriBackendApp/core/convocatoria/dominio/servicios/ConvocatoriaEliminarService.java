package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.port.in.ConvocatoriaActualizarCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.port.in.ConvocatoriaEliminarCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.port.in.ConvocatoriaObtenerCU;
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

        return new RespuestaHandler<>(200, "success.eliminacion.objeto", List.of("Convocatoria"), "Eliminación Lógica", true).getRespuesta();
    }
}
