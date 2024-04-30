package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase Funcionario representa a un funcionario en el sistema.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    /**
     * Identificador único del funcionario.
     */
    private Long id;

    /**
     * Usuario asociado al funcionario.
     */
    private Usuario usuario;
}
