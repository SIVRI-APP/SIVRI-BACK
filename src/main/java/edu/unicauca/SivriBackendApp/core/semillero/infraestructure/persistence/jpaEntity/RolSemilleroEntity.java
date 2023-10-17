package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "rol_semillero")
@Data

public class RolSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45)
    private String rolSemillero;
    //relacion 1a* integranteSemillero
    //@OneToMany(mappedBy = "rolSemillero",fetch = FetchType.LAZY)
    //@JsonBackReference
    //private List<IntegranteSemilleroEntity> integrantes;
}
