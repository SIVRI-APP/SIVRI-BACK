package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.RolPosgradoEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.RolPregradoEntity;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<RolPosgradoEntity> usuariosPosgrado;

    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<RolPregradoEntity> usuariosPregrado;
}
