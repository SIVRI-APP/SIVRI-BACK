package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "evidencia_actividad")
@Getter
@Setter
@AllArgsConstructor

public class EvidenciaActividadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 145)
    private String evidencia;

    //relacion 1a1 con entidad ActividadPlanTrabajo
    @OneToOne(mappedBy ="evidenciaActividad")
    private ActividadPlanTrabajoEntity evidenciaActividad;
}
