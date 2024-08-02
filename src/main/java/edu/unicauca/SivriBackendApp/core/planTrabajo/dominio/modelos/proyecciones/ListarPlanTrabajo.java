package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EstadoPlanTrabajo;

public interface ListarPlanTrabajo {
    Integer getId();
    String getNombrePlan();
    EstadoPlanTrabajo getEstado();
    Integer getAnio();

}
