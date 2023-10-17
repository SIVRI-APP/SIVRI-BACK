package edu.unicauca.SivriBackendApp.core.semillero.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.SemilleroActualizarEstadoDTO;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.SemilleroActualizarREPO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SemilleroActualizarService implements SemilleroActualizarCU {

    private final SemilleroActualizarREPO semilleroActualizarREPO;
    private final SemilleroObtenerCU semilleroObtenerCU;
    public SemilleroActualizarService(SemilleroActualizarREPO semilleroActualizarREPO, SemilleroObtenerCU semilleroObtenerCU) {
        this.semilleroActualizarREPO = semilleroActualizarREPO;
        this.semilleroObtenerCU = semilleroObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizarPorApoyo(Semillero nuevoSemillero) {
        //System.out.println("DATOS SEMILLERO: "+nuevoSemillero);
        Semillero objSemilleroActualizar = semilleroObtenerCU.obtenerSemilleroPorId(nuevoSemillero.getSemilleroId()).getData();
        //System.out.println("id semillero: "+objSemilleroActualizar);
        objSemilleroActualizar.setNombre(nuevoSemillero.getNombre());
        objSemilleroActualizar.setObjetivo(nuevoSemillero.getObjetivo());
        objSemilleroActualizar.setMision(nuevoSemillero.getMision());
        objSemilleroActualizar.setVision(nuevoSemillero.getVision());
        objSemilleroActualizar.setEstado(nuevoSemillero.getEstado());
        objSemilleroActualizar.setSede(nuevoSemillero.getSede());

        Boolean respuesta = semilleroActualizarREPO.actualizarPorApoyo(objSemilleroActualizar);

        if (!respuesta) {
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Semillero", "Id", String.valueOf(nuevoSemillero.getId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Semillero"), "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> actualizarEstadoSemillero(int idSemillero, @Valid SemilleroActualizarEstadoDTO nuevoEstadoSemillero) {
        Semillero objSemilleroActualiza= semilleroObtenerCU.obtenerSemilleroPorId(idSemillero).getData();
        objSemilleroActualiza.setEstado(nuevoEstadoSemillero.getEstado());
        Boolean respuesta=semilleroActualizarREPO.actualizarEstadoSemillero(objSemilleroActualiza);
        if (!respuesta) {
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Semillero", "Id", String.valueOf(nuevoEstadoSemillero.getId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Semillero"), "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> actualizarPorMentor(Semillero nuevoSemillero) {
        //System.out.println("NUEVOSEMILLERO: "+nuevoSemillero);
        Semillero objSemilleroActualizar = semilleroObtenerCU.obtenerSemilleroPorId(nuevoSemillero.getSemilleroId()).getData();
        //System.out.println("IDSEMILLERO: "+nuevoSemillero);
        objSemilleroActualizar.setNombre(nuevoSemillero.getNombre());
        objSemilleroActualizar.setObjetivo(nuevoSemillero.getObjetivo());
        objSemilleroActualizar.setMision(nuevoSemillero.getMision());
        objSemilleroActualizar.setVision(nuevoSemillero.getVision());
        objSemilleroActualizar.setSede(nuevoSemillero.getSede());

        Boolean respuesta = semilleroActualizarREPO.actualizarPorMentor(objSemilleroActualizar);

        if (!respuesta) {
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Semillero", "Id", String.valueOf(nuevoSemillero.getId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Semillero"), "", true).getRespuesta();
    }
}
