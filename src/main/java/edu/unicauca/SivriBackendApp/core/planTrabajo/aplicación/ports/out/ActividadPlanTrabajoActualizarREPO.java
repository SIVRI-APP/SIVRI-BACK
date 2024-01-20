package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;

public interface ActividadPlanTrabajoActualizarREPO {
    Boolean actualizar(ActividadPlanTrabajo nuevosDatosActividad);
}
