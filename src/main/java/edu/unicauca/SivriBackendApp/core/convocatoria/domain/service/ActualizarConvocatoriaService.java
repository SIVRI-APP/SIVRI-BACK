package edu.unicauca.SivriBackendApp.core.convocatoria.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ActualizarConvocatoriaCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ObtenerConvocatoriaCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out.ActualizarConvocatoriaREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActualizarConvocatoriaService implements ActualizarConvocatoriaCU {
    private final ActualizarConvocatoriaREPO actualizarConvocatoriaREPO;
    private final ObtenerConvocatoriaCU obtenerConvocatoriaCU;

    public ActualizarConvocatoriaService(ActualizarConvocatoriaREPO actualizarConvocatoriaREPO, ObtenerConvocatoriaCU obtenerConvocatoriaCU) {
        this.actualizarConvocatoriaREPO = actualizarConvocatoriaREPO;
        this.obtenerConvocatoriaCU = obtenerConvocatoriaCU;
    }

    @Override
    public Respuesta<Boolean> actualizar(Convocatoria nuevosDatos) {
        Convocatoria objetoParaActualizar = obtenerConvocatoriaCU.obtenerPorId(nuevosDatos.getId()).getData();

        objetoParaActualizar.setNombre(nuevosDatos.getNombre());
        objetoParaActualizar.setObjetivos(nuevosDatos.getObjetivos());
        objetoParaActualizar.setOferente(nuevosDatos.getOferente());
        objetoParaActualizar.setFechaInicio(nuevosDatos.getFechaInicio());
        objetoParaActualizar.setFechaFin(nuevosDatos.getFechaFin());
        objetoParaActualizar.setRecurrente(nuevosDatos.isRecurrente());
        objetoParaActualizar.setEstado(nuevosDatos.getEstado());

        boolean respuesta = actualizarConvocatoriaREPO.actualizar(objetoParaActualizar);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Convocatoria", "Id", String.valueOf(nuevosDatos.getId())));
        }

        return new RespuestaHandler<>(200, "Actualización exitosa", "", true).getRespuesta();
    }
}
