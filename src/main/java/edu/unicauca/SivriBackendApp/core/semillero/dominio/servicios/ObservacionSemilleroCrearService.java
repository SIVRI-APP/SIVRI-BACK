package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.ObservacionSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.ObservacionSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.ObservacionSemilleroCrearDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ObservacionSemilleroCrearService implements ObservacionSemilleroCrearCU {

    private final ObservacionSemilleroCrearREPO observacionSemilleroCrearREPO;

    public ObservacionSemilleroCrearService(ObservacionSemilleroCrearREPO observacionSemilleroCrearREPO) {
        this.observacionSemilleroCrearREPO = observacionSemilleroCrearREPO;
    }


    @Override
    public Respuesta<Boolean> crear(Long funcionarioId, int semilleroId, ObservacionSemillero observacionSemillero) {

        observacionSemillero.setFuncionarioId(funcionarioId);
        observacionSemillero.setSemilleroId(semilleroId);
        observacionSemillero.setFecha(LocalDate.now());

        Boolean respuesta= observacionSemilleroCrearREPO.crear(observacionSemillero);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Observacion Semillero","Id",String.valueOf(observacionSemillero.getId())));
        }
        return new RespuestaHandler<>(201,"success.creacion.objeto",List.of("Observacion Semillero"),"",true).getRespuesta();
    }
}
