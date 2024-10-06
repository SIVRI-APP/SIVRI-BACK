package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rol_semillero")
@Data

public class RolSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_semillero_seq")
    @SequenceGenerator(name = "rol_semillero_seq", sequenceName = "rol_semillero_sequence", initialValue = 7, allocationSize = 1)
    private Integer id;
    @Column(length = 45)
    private String rolSemillero;
    //relacion 1a* integranteSemillero
    //@OneToMany(mappedBy = "rolSemillero",fetch = FetchType.LAZY)
    //@JsonBackReference
    //private List<IntegranteSemilleroEntity> integrantes;
}
