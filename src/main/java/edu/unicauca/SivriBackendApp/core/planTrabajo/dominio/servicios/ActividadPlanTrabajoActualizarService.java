package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.ActividadPlanTrabajoActualizarCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.ActividadPlanTrabajoObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.CompromisoSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.ActividadPlanTrabajoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
        System.out.println("actividad de la bd "+objActividadActualizar);
        System.out.println("fecha inicio de la bd "+objActividadActualizar.getFechaInicio()+" fecha fin de bd "+objActividadActualizar.getFechaFin());

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
