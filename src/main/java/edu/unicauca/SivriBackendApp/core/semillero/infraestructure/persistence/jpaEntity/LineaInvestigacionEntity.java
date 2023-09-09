package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "linea_investigacion")
@Getter
@Setter
@AllArgsConstructor
public class LineaInvestigacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45,nullable = false)
    private String linea;

    //relacion *a1 con entidad semillero
    @ManyToOne(optional = false)
    @JoinColumn(name = "semilleroId")
    private SemilleroEntity idSemillero;
}
