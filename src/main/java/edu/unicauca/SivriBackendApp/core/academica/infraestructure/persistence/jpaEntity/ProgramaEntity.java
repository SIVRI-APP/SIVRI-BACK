package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.SemilleroEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.RolPosgradoEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.RolPregradoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "programa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departamentoId")
    private DepartamentoEntity departamento;

    //relacion *a* con semillero
    /* @ManyToMany(mappedBy = "programas")
    private List<SemilleroEntity> semilleros;
    */
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY)
    private List<RolPosgradoEntity> usuariosPosgrado;

    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY)
    private List<RolPregradoEntity> usuariosPregrado;
}
