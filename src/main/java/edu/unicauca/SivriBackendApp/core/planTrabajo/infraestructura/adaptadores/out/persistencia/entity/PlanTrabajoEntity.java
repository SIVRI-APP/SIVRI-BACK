package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EstadoPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.SemilleroEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "plan_trabajo", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"semilleroId", "anio"})
})
@Data
public class PlanTrabajoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    private Integer anio;
    //relacion 1a* actividadPlanTrabajo
    /*@OneToMany(mappedBy = "planTrabajo", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ActividadPlanTrabajoEntity> actividades;
*/

    @Override
    public String toString() {
        return "PlanTrabajoEntity{" +
                "id=" + id +
                ", nombrePlan='" + nombrePlan + '\'' +
                ", estado=" + estado +
                ", semillero=" + semillero +
                ", anio=" + anio +
                '}';
    }

}
