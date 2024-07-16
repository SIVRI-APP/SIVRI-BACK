package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
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
    private Long responsableUsuarioId;

}
