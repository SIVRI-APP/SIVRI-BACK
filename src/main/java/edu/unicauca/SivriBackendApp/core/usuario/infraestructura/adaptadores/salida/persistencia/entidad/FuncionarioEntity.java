package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Representa la entidad de persistencia para los funcionarios del sistema.
 */
@Entity
@Table(name = "funcionario")
@Data
public class FuncionarioEntity {

    /**
     * Identificador único del funcionario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Usuario asociado al funcionario.
     */
    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private UsuarioEntity usuario;

}
