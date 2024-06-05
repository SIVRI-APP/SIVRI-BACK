package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.time.LocalDate;

/**
 * Representa la entidad de persistencia para los funcionarios del sistema.
 */
@Entity
@Table(name = "funcionario")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioEntity {

    /** Identificador único del funcionario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Usuario asociado al funcionario */
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarioId")
    private UsuarioEntity usuario;

    /** Rol del funcionario asociado al rol administrativo */
    @ManyToOne(optional = false)
    @JoinColumn(name = "rolId")
    private RolFuncionarioEntity rolFuncionario;

    /** Estado del rol administrativo */
    @Column(nullable = false)
    private Boolean estado;

    /** Fecha de inicio del rol administrativo. Debe ser una fecha presente o futura */
    @FutureOrPresent
    private LocalDate fechaInicio;

    /** Fecha de finalización del rol administrativo. Debe ser una fecha presente o futura */
    @FutureOrPresent
    private LocalDate fechaFin;

}
