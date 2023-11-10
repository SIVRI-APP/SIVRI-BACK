package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.ActividadPlanTrabajoActualizarCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.ActividadPlanTrabajoObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.CompromisoSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out.ActividadPlanTrabajoActualizarREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActividadPlanTrabajoActualizarService implements ActividadPlanTrabajoActualizarCU {
    private final ActividadPlanTrabajoActualizarREPO actividadPlanTrabajoREPO;
    private final ActividadPlanTrabajoObtenerCU actividadPlanTrabajoObtenerCU;
    private final CompromisoSemilleroObtenerCU compromisoSemilleroObtenerCU;

    public ActividadPlanTrabajoActualizarService(ActividadPlanTrabajoActualizarREPO actividadPlanTrabajoREPO, ActividadPlanTrabajoObtenerCU actividadPlanTrabajoObtenerCU, CompromisoSemilleroObtenerCU compromisoSemilleroObtenerCU) {
        this.actividadPlanTrabajoREPO = actividadPlanTrabajoREPO;
        this.actividadPlanTrabajoObtenerCU = actividadPlanTrabajoObtenerCU;
        this.compromisoSemilleroObtenerCU = compromisoSemilleroObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizar(int idActividad, ActividadPlanTrabajo nuevosDatosActividad) {
        System.out.println("mentor "+nuevosDatosActividad.getResponsableUsuarioId());
        System.out.println("id actividad "+idActividad+" DATOS llegan "+nuevosDatosActividad);
        compromisoSemilleroObtenerCU.existePorId(nuevosDatosActividad.getCompromiso().getId());
        //TODO falta validar el usuario
        ActividadPlanTrabajo objActividadActualizar=actividadPlanTrabajoObtenerCU.obtenerPorId(idActividad).getData();
        objActividadActualizar.setObjetivo(nuevosDatosActividad.getObjetivo());
        objActividadActualizar.setActividad(nuevosDatosActividad.getActividad());
        objActividadActualizar.setCompromiso(nuevosDatosActividad.getCompromiso());
        objActividadActualizar.setResponsableUsuarioId(nuevosDatosActividad.getResponsableUsuarioId());
        objActividadActualizar.setFechaInicio(nuevosDatosActividad.getFechaInicio());
        objActividadActualizar.setFechaFin(nuevosDatosActividad.getFechaFin());
        System.out.println("datos editados en service "+objActividadActualizar);
        boolean respuesta =actividadPlanTrabajoREPO.actualizar(objActividadActualizar);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Actividad Plan Trabajo", "Id", String.valueOf(idActividad)));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Actividad Plan Trabajo"), "", true).getRespuesta();
    }
}
