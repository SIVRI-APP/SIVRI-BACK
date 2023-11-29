package edu.unicauca.SivriBackendApp.core.semillero.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.IntegranteSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.RolesSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.IntegranteSemilleroCrearREPO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
@Component
public class IntegranteSemilleroCrearService implements IntegranteSemilleroCrearCU {
    private final IntegranteSemilleroCrearREPO integranteSemilleroCrearREPO;
    private final RolesSemilleroObtenerCU rolesSemilleroObtenerCU;

    public IntegranteSemilleroCrearService(IntegranteSemilleroCrearREPO integranteSemilleroCrearREPO, RolesSemilleroObtenerCU rolesSemilleroObtenerCU) {
        this.integranteSemilleroCrearREPO = integranteSemilleroCrearREPO;
        this.rolesSemilleroObtenerCU = rolesSemilleroObtenerCU;
    }

    @Override
    public Respuesta<Boolean> crear(IntegranteSemillero nuevosIntegranteSemillero) {
        rolesSemilleroObtenerCU.existePorId(nuevosIntegranteSemillero.getRolSemillero().getId());
        nuevosIntegranteSemillero.setEstado(EstadoIntegranteSemillero.ACTIVO);
        nuevosIntegranteSemillero.setFechaIngreso(LocalDate.now());
        System.out.println("DATOS NUEVO INTEGRANTE service "+nuevosIntegranteSemillero);
        Boolean respuesta=integranteSemilleroCrearREPO.crear(nuevosIntegranteSemillero);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Integrante Semillero", "Id", String.valueOf(nuevosIntegranteSemillero.getId())));
        }
        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Integrante Semillero"), "", true).getRespuesta();
    }
}
