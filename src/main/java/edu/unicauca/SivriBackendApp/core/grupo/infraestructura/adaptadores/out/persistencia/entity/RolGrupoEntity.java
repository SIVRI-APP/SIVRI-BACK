package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rol_grupo")
@Data
public class RolGrupoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_grupo_seq")
    @SequenceGenerator(name = "rol_grupo_seq", sequenceName = "rol_grupo_seq", initialValue = 11, allocationSize = 1)
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
