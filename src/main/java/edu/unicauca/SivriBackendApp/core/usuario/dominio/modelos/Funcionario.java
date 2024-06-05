package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.RolFuncionarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import lombok.*;

import java.time.LocalDate;

/**
 * Representa la entidad de persistencia para los funcionarios del sistema.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    /** Identificador único del funcionario */
    private Long id;

    /** Usuario asociado al funcionario */
    private UsuarioEntity usuario;

    /** Rol del funcionario asociado al rol administrativo */
    private RolFuncionarioEntity rolFuncionario;

    /** Estado del rol administrativo */
    private Boolean estado;

    /** Fecha de inicio del rol administrativo. Debe ser una fecha presente o futura */
    private LocalDate fechaInicio;

    /** Fecha de finalización del rol administrativo. Debe ser una fecha presente o futura */
    private LocalDate fechaFin;

}
