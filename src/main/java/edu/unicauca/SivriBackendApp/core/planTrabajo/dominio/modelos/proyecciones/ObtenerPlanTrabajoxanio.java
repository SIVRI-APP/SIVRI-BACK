package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EstadoPlanTrabajo;

import java.time.LocalDate;

public interface ObtenerPlanTrabajoxanio {
    Integer getId();
    Integer getIdPlan();
    Integer getEvidenciaId();
    String getActividad();
    String getCompromiso();
    LocalDate getFechaInicio();
    LocalDate getFechaFin();
    String getResponsable();
}
