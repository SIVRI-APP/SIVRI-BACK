package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;

public interface PlanTrabajoActualizarREPO {
    Boolean actualizar (PlanTrabajo nuevoPlanTrabajo);
}
