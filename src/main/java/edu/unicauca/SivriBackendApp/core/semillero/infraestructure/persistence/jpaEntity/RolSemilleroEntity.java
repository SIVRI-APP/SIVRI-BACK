package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rol_semillero")
@Getter
@Setter
@AllArgsConstructor
public class RolSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45)
    private String rolSemillero;
    //relacion 1a* integranteSemillero
    @OneToMany(mappedBy = "idRol",fetch = FetchType.LAZY)
    private List<IntegranteSemilleroEntity> integrantes;
}
