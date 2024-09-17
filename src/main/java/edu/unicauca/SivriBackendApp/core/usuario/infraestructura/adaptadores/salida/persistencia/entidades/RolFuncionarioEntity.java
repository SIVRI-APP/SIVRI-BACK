package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

/**
 * Representa la entidad de persistencia para los roles de los funcionarios en el sistema.
 */
@Entity
@Table(name = "rol_funcionario")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolFuncionarioEntity {

    /** Identificador único del rol del funcionario */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /** Relación uno a muchós mapeada por el campo rolFuncionario de la tabla Funcionario */
    @OneToMany(mappedBy = "rolFuncionario")
    private Set<FuncionarioEntity> funcionarios;

    /** Nombre del rol del funcionario. Es un campo obligatorio y tiene una longitud máxima de 45 caracteres */
    @Column(nullable = false, length = 100)
    private String nombre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolFuncionarioEntity that = (RolFuncionarioEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
