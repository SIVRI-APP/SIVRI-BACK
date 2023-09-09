package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "plan_trabajo")
@Getter
@Setter
@AllArgsConstructor
public class PlanTrabajoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45)
    private String nombrePlan;
    @Column(length = 9)
    private String estado;
    //relacion *a1 semillero
    @ManyToOne(optional = false)
    @JoinColumn(name = "semilleroId")
    private SemilleroEntity idSemillero;
    //relacion 1a* actividadPlanTrabajo
    @OneToMany(mappedBy = "idPlanTrabajo", fetch = FetchType.LAZY)
    private List<ActividadPlanTrabajoEntity> actividades;

}
