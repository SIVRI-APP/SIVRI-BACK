package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EvidenciaActividad;

import java.util.Optional;

public interface EvidenciaActividadREPO {
    Integer existexActividadId(int idActividad);
    Optional<EvidenciaActividad> obtenerPorId(int id);
    Boolean subirEvidenciaActividad(EvidenciaActividad nuevaEvidencia);
}
