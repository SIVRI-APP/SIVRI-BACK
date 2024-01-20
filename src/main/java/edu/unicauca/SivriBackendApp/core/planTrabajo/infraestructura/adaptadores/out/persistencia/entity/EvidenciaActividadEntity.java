package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "evidencia_actividad")
@Data

public class EvidenciaActividadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 145)
    private String evidencia;

    //relacion 1a1 con entidad ActividadPlanTrabajo
    //@OneToOne(mappedBy ="evidenciaActividad")
    //private ActividadPlanTrabajoEntity evidenciaActividad;
}
