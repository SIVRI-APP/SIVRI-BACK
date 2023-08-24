package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tipousuario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class TipoUsuario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

}
