package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "rol_grupo")
@Data
public class RolGrupoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45)
    private String rolGrupo;

    //relacion 1a* con entidad integrantegrupo
    /*@OneToMany(mappedBy = "rolGrupo",fetch = FetchType.LAZY)
    private List<IntegranteGrupoEntity> integrantesGrupo;
*/

    @Override
    public String toString() {
        return "RolGrupoEntity{" +
                "id=" + id +
                ", rolGrupo='" + rolGrupo + '\'' +
                '}';
    }
}
