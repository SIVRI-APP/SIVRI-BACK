package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.EstadoPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.SemilleroEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "plan_trabajo")
@Data
public class PlanTrabajoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45)
    private String nombrePlan;
    @Column(length = 9,nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPlanTrabajo estado;
    //relacion *a1 semillero
    @ManyToOne(optional = false)
    @JsonManagedReference
    @JoinColumn(name = "semilleroId")
    private SemilleroEntity semillero;
    //relacion 1a* actividadPlanTrabajo
    @OneToMany(mappedBy = "planTrabajo", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ActividadPlanTrabajoEntity> actividades;

}
