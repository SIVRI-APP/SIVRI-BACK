package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="actividad_plan_trabajo")
@Getter
@Setter
@NoArgsConstructor
public class ActividadPlanTrabajoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 1045)
    private String objetivo;
    @Column(length = 145)
    private String actividad;
    @FutureOrPresent
    private LocalDate fechaInicio;
    @FutureOrPresent
    private LocalDate fechaFin;
    //relacion *a1 plantrabajo
    @ManyToOne
    @JoinColumn(name = "planTrabajoId")
    private PlanTrabajoEntity idPlanTrabajo;
    //relacion 1a1 evidenciaActividad
    @OneToOne
    @JoinColumn(name = "idEvidencia")
    private EvidenciaActividadEntity idEvidencia;
    //relacion *a1 compromisoSemillero
    @ManyToOne
    @JoinColumn(name = "compromisoSemilleroId")
    private CompromisoSemilleroEntity idCompromiso;
    //relacion *a1 usuario
    @ManyToOne(optional = false)
    @JoinColumn(name = "responsable")
    private UsuarioEntity idResponsable;
}
