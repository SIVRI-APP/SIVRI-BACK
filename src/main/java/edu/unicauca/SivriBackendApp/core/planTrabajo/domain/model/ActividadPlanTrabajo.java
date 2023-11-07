package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model;

import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.CompromisoSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.EvidenciaActividadEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.PlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ActividadPlanTrabajo {
    private Integer id;
    private String objetivo;
    private String actividad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private PlanTrabajo planTrabajo;
    private EvidenciaActividad evidenciaActividad;
    private CompromisoSemillero compromiso;
    //TODO SE DEBE CAMBIAR PORELMODELO
    private String responsableUsuarioId;

}
