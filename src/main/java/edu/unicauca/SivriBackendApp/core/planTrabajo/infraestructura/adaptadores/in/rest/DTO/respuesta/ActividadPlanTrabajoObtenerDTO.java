package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.CompromisoSemillero;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EvidenciaActividad;
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
    private EvidenciaActividad evidenciaActividad;
    private CompromisoSemillero compromiso;
    //TODO DEBE MOSTRAR EL NOMBRE DEL RESPONSABLE DE LA ACTIVIDAD
    private Long responsableUsuarioId;
}
