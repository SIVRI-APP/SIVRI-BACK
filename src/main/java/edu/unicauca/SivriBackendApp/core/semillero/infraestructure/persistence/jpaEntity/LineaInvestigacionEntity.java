package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "linea_investigacion")
@Data
public class LineaInvestigacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45,nullable = false)
    private String linea;

    //relacion *a1 con entidad semillero
    @ManyToOne(optional = false)
    @JoinColumn(name = "semilleroId")
    private SemilleroEntity semillero;
}
