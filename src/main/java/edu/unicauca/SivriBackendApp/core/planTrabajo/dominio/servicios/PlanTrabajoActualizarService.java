package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.PlanTrabajoActualizarCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.PlanTrabajoObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.PlanTrabajoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanTrabajoActualizarService implements PlanTrabajoActualizarCU {

    private final PlanTrabajoActualizarREPO planTrabajoActualizarREPO;
    private final PlanTrabajoObtenerCU planTrabajoObtenerCU;

    public PlanTrabajoActualizarService(PlanTrabajoActualizarREPO planTrabajoActualizarREPO, PlanTrabajoObtenerCU planTrabajoObtenerCU) {
        this.planTrabajoActualizarREPO = planTrabajoActualizarREPO;
        this.planTrabajoObtenerCU = planTrabajoObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizar(int idPlan, PlanTrabajo nuevosDatosPlan) {
        try {
            PlanTrabajo objPlanActualizar= planTrabajoObtenerCU.obtenerPorId(idPlan).getData();
            objPlanActualizar.setNombrePlan(nuevosDatosPlan.getNombrePlan());
            objPlanActualizar.setEstado(nuevosDatosPlan.getEstado());
            objPlanActualizar.setAnio(nuevosDatosPlan.getAnio());
            boolean respuesta = planTrabajoActualizarREPO.actualizar(objPlanActualizar);
            System.out.println("respuesta "+respuesta);
            if (!respuesta){
                throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Plan Trabajo", "Id", String.valueOf(idPlan)));
            }

            return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Plan Trabajo"), "", true).getRespuesta();
        }catch (DataIntegrityViolationException e) {
            String mensajeError = e.getRootCause().getMessage();
            if (mensajeError.contains("Duplicate entry")) {
                throw new ReglaDeNegocioException("bad.registro.anio.semillero.duplicado",
                        List.of("Plan Trabajo", "Año", String.valueOf(nuevosDatosPlan.getAnio())));
            } else {
                throw new ReglaDeNegocioException("Error de integridad al actualizar el Plan de Trabajo",
                        List.of("Plan Trabajo", "Id", String.valueOf(idPlan)));
            }
        }
    }
}
