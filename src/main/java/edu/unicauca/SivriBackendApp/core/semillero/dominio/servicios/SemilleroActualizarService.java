package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.SemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
@AllArgsConstructor
@Component
public  class SemilleroActualizarService implements SemilleroActualizarCU {

    private final SemilleroActualizarREPO semilleroActualizarREPO;
    private final SemilleroObtenerCU semilleroObtenerCU;

    @Override
    public Respuesta<Boolean> actualizarPorApoyo(Semillero nuevoSemillero) {
        semilleroObtenerCU.existePorId(nuevoSemillero.getSemillero_Id());
        String nombreLLega=nuevoSemillero.getNombre();
        Semillero objSemilleroActualizar = semilleroObtenerCU.obtenerSemilleroPorId(nuevoSemillero.getSemillero_Id()).getData();
        String nombreBd=objSemilleroActualizar.getNombre();
        if (!Objects.equals(nombreLLega, nombreBd)){
            semilleroObtenerCU.existePorNombre(nuevoSemillero.getNombre());
        }
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
    public Respuesta<Boolean> actualizarEstadoSemillero(int idSemillero, Semillero nuevoEstadoSemillero) {
       semilleroObtenerCU.existePorId(idSemillero);
        Semillero objSemilleroActualizar=semilleroObtenerCU.obtenerSemilleroPorId(idSemillero).getData();

        objSemilleroActualizar.setEstado(nuevoEstadoSemillero.getEstado());
        Boolean respuesta=semilleroActualizarREPO.actualizarEstadoSemillero(objSemilleroActualizar);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Semillero", "Id", String.valueOf(objSemilleroActualizar.getSemillero_Id())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Estado Semillero"), "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> actualizarPorMentor(Semillero nuevoSemillero) {
        semilleroObtenerCU.existePorId(nuevoSemillero.getSemillero_Id());
        String nombreLLega=nuevoSemillero.getNombre();
        Semillero objSemilleroActualizar = semilleroObtenerCU.obtenerSemilleroPorId(nuevoSemillero.getSemillero_Id()).getData();
        String nombreBd=objSemilleroActualizar.getNombre();
        if (!Objects.equals(nombreLLega, nombreBd)){
            semilleroObtenerCU.existePorNombre(nuevoSemillero.getNombre());
        }
       objSemilleroActualizar.setNombre(nuevoSemillero.getNombre());
        objSemilleroActualizar.setCorreo(nuevoSemillero.getCorreo());
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
