package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "linea_investigacion")
@Data
public class LineaInvestigacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 45,nullable = false)
    private String linea;

    //relacion *a1 con entidad semillero
    @ManyToOne(optional = false)
    @JoinColumn(name = "semilleroId")
    private SemilleroEntity semillero;
}
