package edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.response;

import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.CompromisoSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.EvidenciaActividadEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.PlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ActividadPlanTrabajoObtenerDTO {
    private Integer id;
    private String objetivo;
    private String actividad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer planTrabajoId;
    private EvidenciaActividadEntity evidenciaActividad;
    private CompromisoSemilleroEntity compromiso;
    //TODO DEBE MOSTRAR EL NOMBRE DEL RESPONSABLE DE LA ACTIVIDAD
    //private UsuarioEntity responsableUsuario;
}
