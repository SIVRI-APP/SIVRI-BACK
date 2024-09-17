package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rol_semillero")
@Data

public class RolSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 45)
    private String rolSemillero;
    //relacion 1a* integranteSemillero
    //@OneToMany(mappedBy = "rolSemillero",fetch = FetchType.LAZY)
    //@JsonBackReference
    //private List<IntegranteSemilleroEntity> integrantes;
}
