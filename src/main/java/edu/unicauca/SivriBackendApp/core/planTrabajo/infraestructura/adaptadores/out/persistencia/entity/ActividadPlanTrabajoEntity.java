package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="actividad_plan_trabajo")
@Data
public class ActividadPlanTrabajoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 1045)
    private String objetivo;
    @Column(length = 145)
    private String actividad;
    //@FutureOrPresent
    private LocalDate fechaInicio;
    //@FutureOrPresent
    private LocalDate fechaFin;
    //relacion *a1 plantrabajo
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "planTrabajoId")
    private PlanTrabajoEntity planTrabajo;
    //relacion 1a1 evidenciaActividad
    //@OneToOne
    //@JoinColumn(name = "evidenciaId")
    //private EvidenciaActividadEntity evidenciaActividad;
    //relacion *a1 compromisoSemillero
    @ManyToOne
    @JoinColumn(name = "compromisoSemilleroId")
    private CompromisoSemilleroEntity compromiso;
    //relacion *a1 usuario

    @ManyToOne(optional = false)
    @JoinColumn(name = "responsableId")
    private UsuarioEntity responsableUsuario;
}
