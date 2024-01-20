package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.SemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.SemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public  class SemilleroActualizarService implements SemilleroActualizarCU {

    private final SemilleroActualizarREPO semilleroActualizarREPO;
    private final SemilleroObtenerCU semilleroObtenerCU;
    public SemilleroActualizarService(SemilleroActualizarREPO semilleroActualizarREPO, SemilleroObtenerCU semilleroObtenerCU) {
        this.semilleroActualizarREPO = semilleroActualizarREPO;
        this.semilleroObtenerCU = semilleroObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizarPorApoyo(Semillero nuevoSemillero) {
        //System.out.println("DATOS SEMILLERO: "+nuevoSemillero);
        semilleroObtenerCU.existePorId(nuevoSemillero.getSemilleroId());
        String nombreLLega=nuevoSemillero.getNombre();
        Semillero objSemilleroActualizar = semilleroObtenerCU.obtenerSemilleroPorId(nuevoSemillero.getSemilleroId()).getData();
        String nombreBd=objSemilleroActualizar.getNombre();
        if (!Objects.equals(nombreLLega, nombreBd)){
            semilleroObtenerCU.existePorNombre(nuevoSemillero.getNombre());
        }
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
    public Respuesta<Boolean> actualizarEstadoSemillero(int idSemillero, Semillero nuevoEstadoSemillero) {
        System.out.println("ENTRA AL SERVICE");
        System.out.println("id semillero "+idSemillero+" semillero que llega "+nuevoEstadoSemillero);
        semilleroObtenerCU.existePorId(idSemillero);
        Semillero objSemilleroActualizar=semilleroObtenerCU.obtenerSemilleroPorId(idSemillero).getData();
        System.out.println("obj semillero que se obtiene "+objSemilleroActualizar);

        objSemilleroActualizar.setEstado(nuevoEstadoSemillero.getEstado());
        System.out.println("semillero con actualizacion "+objSemilleroActualizar);
        Boolean respuesta=semilleroActualizarREPO.actualizarEstadoSemillero(objSemilleroActualizar);
        System.out.println("respuesta "+respuesta);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Semillero", "Id", String.valueOf(objSemilleroActualizar.getSemilleroId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Estado Semillero"), "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> actualizarPorMentor(Semillero nuevoSemillero) {
        //System.out.println("NUEVOSEMILLERO: "+nuevoSemillero);
        semilleroObtenerCU.existePorId(nuevoSemillero.getSemilleroId());
        String nombreLLega=nuevoSemillero.getNombre();
        Semillero objSemilleroActualizar = semilleroObtenerCU.obtenerSemilleroPorId(nuevoSemillero.getSemilleroId()).getData();
        String nombreBd=objSemilleroActualizar.getNombre();
        if (!Objects.equals(nombreLLega, nombreBd)){
            semilleroObtenerCU.existePorNombre(nuevoSemillero.getNombre());
        }
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
