package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.EstadoPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.PlanTrabajoCrearCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out.PlanTrabajoCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroObtenerCU;
import org.hibernate.loader.NonUniqueDiscoveredSqlAliasException;
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
    public Respuesta<Boolean> crear(PlanTrabajo nuevoPlan) {
        System.out.println("DATOS QUE LLEGAN AL SERVICE "+nuevoPlan);


        System.out.println("el semillero existe "+nuevoPlan.getSemillero().getSemilleroId()+
                " : "+semilleroObtenerCU.existePorId(nuevoPlan.getSemillero().getSemilleroId()));
        nuevoPlan.setEstado(EstadoPlanTrabajo.FORMULADO);


        System.out.println("nueuvo plan "+nuevoPlan);
        Boolean respuesta=planTrabajoCrearREPO.crear(nuevoPlan);
        System.out.println("RESPUESTA SERVICE "+respuesta);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Plan Trabajo", "Id", String.valueOf(nuevoPlan.getId())));
        }
        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Plan Trabajo"), "", true).getRespuesta();
    }

}
