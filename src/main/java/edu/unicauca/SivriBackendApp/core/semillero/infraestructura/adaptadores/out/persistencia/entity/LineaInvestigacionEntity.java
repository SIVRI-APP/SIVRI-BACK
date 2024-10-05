package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "linea_investigacion")
@Data
public class LineaInvestigacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "linea_investigacion_seq")
    @SequenceGenerator(name = "linea_investigacion_seq",sequenceName = "lineaInvestigacion_sequence", initialValue = 3, allocationSize = 1)
    private Integer id;
    @Column(length = 45,nullable = false)
    private String linea;

    //relacion *a1 con entidad semillero
    @ManyToOne(optional = false)
    @JoinColumn(name = "semillero_Id")
    private SemilleroEntity semillero;
}
