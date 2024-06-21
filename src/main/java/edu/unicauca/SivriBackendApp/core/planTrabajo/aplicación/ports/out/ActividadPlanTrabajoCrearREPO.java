package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;

public interface ActividadPlanTrabajoCrearREPO {
    Boolean crear(ActividadPlanTrabajo nuevaActividad);
}
