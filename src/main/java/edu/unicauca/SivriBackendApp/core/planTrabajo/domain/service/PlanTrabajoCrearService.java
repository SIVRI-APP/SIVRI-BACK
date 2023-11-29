package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.EstadoPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.PlanTrabajoCrearCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out.PlanTrabajoCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroObtenerCU;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanTrabajoCrearService implements PlanTrabajoCrearCU {
    private final PlanTrabajoCrearREPO planTrabajoCrearREPO;
    private final SemilleroObtenerCU semilleroObtenerCU;

    public PlanTrabajoCrearService(PlanTrabajoCrearREPO planTrabajoCrearREPO, SemilleroObtenerCU semilleroObtenerCU) {
        this.planTrabajoCrearREPO = planTrabajoCrearREPO;
        this.semilleroObtenerCU = semilleroObtenerCU;
    }

    @Override
    public Respuesta<Boolean> crear(int idSemillero, PlanTrabajo nuevoPlan) {
        //System.out.println("DATOS QUE LLEGAN AL SERVICE "+idSemillero+" nuevo plan "+nuevoPlan);
        nuevoPlan.setEstado(EstadoPlanTrabajo.FORMULADO);
        Semillero semillero= semilleroObtenerCU.obtenerSemilleroPorId(idSemillero).getData();
        nuevoPlan.setSemillero(semillero);
        //System.out.println("nuevo plan "+nuevoPlan);
        Boolean respuesta= planTrabajoCrearREPO.crear(nuevoPlan);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Plan Trabajo", "Id", String.valueOf(nuevoPlan.getId())));
        }
        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Plan Trabajo"), "", true).getRespuesta();
    }

}
