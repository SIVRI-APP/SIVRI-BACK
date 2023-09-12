package edu.unicauca.SivriBackendApp.core.convocatoria.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaActualizarCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.TipoFinanciacionObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out.ConvocatoriaActualizarREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvocatoriaActualizarService implements ConvocatoriaActualizarCU {
    private final ConvocatoriaActualizarREPO convocatoriaActualizarREPO;
    private final ConvocatoriaObtenerCU convocatoriaObtenerCU;
    private final TipoFinanciacionObtenerCU tipoFinanciacionObtenerCU;

    public ConvocatoriaActualizarService(ConvocatoriaActualizarREPO convocatoriaActualizarREPO, ConvocatoriaObtenerCU convocatoriaObtenerCU, TipoFinanciacionObtenerCU tipoFinanciacionObtenerCU) {
        this.convocatoriaActualizarREPO = convocatoriaActualizarREPO;
        this.convocatoriaObtenerCU = convocatoriaObtenerCU;
        this.tipoFinanciacionObtenerCU = tipoFinanciacionObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizar(Convocatoria nuevosDatos) {

        Convocatoria objetoParaActualizar = convocatoriaObtenerCU.obtenerPorId(nuevosDatos.getId()).getData();

        objetoParaActualizar.setNombre(nuevosDatos.getNombre());
        objetoParaActualizar.setObjetivos(nuevosDatos.getObjetivos());
        objetoParaActualizar.setOferente(nuevosDatos.getOferente());
        objetoParaActualizar.setFechaInicio(nuevosDatos.getFechaInicio());
        objetoParaActualizar.setFechaFin(nuevosDatos.getFechaFin());
        objetoParaActualizar.setRecurrente(nuevosDatos.isRecurrente());
        objetoParaActualizar.setEliminadoLogico(nuevosDatos.isEliminadoLogico());
        objetoParaActualizar.setEstado(nuevosDatos.getEstado());

        tipoFinanciacionObtenerCU.existePorId(nuevosDatos.getTipoFinanciacion().getId());
        objetoParaActualizar.getTipoFinanciacion().setId(nuevosDatos.getTipoFinanciacion().getId());

        boolean respuesta = convocatoriaActualizarREPO.actualizar(objetoParaActualizar);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Convocatoria", "Id", String.valueOf(nuevosDatos.getId())));
        }

        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Convocatoria"), "", true).getRespuesta();
    }
}
