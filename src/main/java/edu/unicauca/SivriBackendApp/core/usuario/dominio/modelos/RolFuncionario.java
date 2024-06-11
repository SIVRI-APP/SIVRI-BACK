package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import lombok.*;

import java.util.Set;

/**
 * Representa la entidad de persistencia para los roles de los funcionarios en el sistema.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolFuncionario {

    /** Identificador único del rol del funcionario */
    private Long id;

    /** Relación uno a muchós mapeada por el campo rolFuncionario de la tabla Funcionario */
    private Set<Funcionario> funcionarios;

    /** Nombre del rol del funcionario. Es un campo obligatorio y tiene una longitud máxima de 45 caracteres */
    private String nombre;

}
