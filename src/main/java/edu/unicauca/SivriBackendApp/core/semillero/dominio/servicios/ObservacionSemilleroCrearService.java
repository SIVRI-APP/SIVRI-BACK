package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificacionDeUsuario;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.ObservacionSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.ObservacionSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class ObservacionSemilleroCrearService implements ObservacionSemilleroCrearCU {

    private final ObservacionSemilleroCrearREPO observacionSemilleroCrearREPO;
    private final ServicioDeIdentificacionDeUsuario servicioDeIdentificacionDeUsuario;

    @Override
    public Respuesta<Boolean> crear( int semilleroId, ObservacionSemillero observacionSemillero) {
        Long funcionarioId = servicioDeIdentificacionDeUsuario.obtenerFuncionarioModel().getId();
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
