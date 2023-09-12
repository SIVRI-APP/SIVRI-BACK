package edu.unicauca.SivriBackendApp.core.convocatoria.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;

import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ActualizarConvocatoriaCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.EliminarConvocatoriaCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ObtenerConvocatoriaCU;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EliminarConvocatoriaService implements EliminarConvocatoriaCU {

    private final ActualizarConvocatoriaCU actualizarConvocatoriaCU;
    private final ObtenerConvocatoriaCU obtenerConvocatoriaCU;

    public EliminarConvocatoriaService(ActualizarConvocatoriaCU actualizarConvocatoriaCU, ObtenerConvocatoriaCU obtenerConvocatoriaCU) {
        this.actualizarConvocatoriaCU = actualizarConvocatoriaCU;
        this.obtenerConvocatoriaCU = obtenerConvocatoriaCU;
    }

    @Override
    public Respuesta<Boolean> eliminadoLogico(long id) {
        Convocatoria objetoParaEliminadoLogico = obtenerConvocatoriaCU.obtenerPorId(id).getData();
        objetoParaEliminadoLogico.setEliminadoLogico(true);

        Boolean respuesta = actualizarConvocatoriaCU.actualizar(objetoParaEliminadoLogico).getData();

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.eliminacion.objeto", List.of("Convocatoria", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "Eliminación exitosa", "Eliminación Lógica", true).getRespuesta();
    }
}
