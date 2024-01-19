package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;

/**
 * Representa la entidad de persistencia para los roles administrativos de los funcionarios del sistema.
 */
@Entity
@Table(name = "rol_administrativo")
@Data
public class RolAdministrativoEntity {

    /**
     * Identificador único del rol administrativo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Funcionario asociado al rol administrativo.
     */
    @ManyToOne
    @JoinColumn(name = "funcionarioId")
    private FuncionarioEntity funcionario;

    /**
     * Rol del funcionario asociado al rol administrativo.
     */
    @ManyToOne
    @JoinColumn(name = "rolFuncionarioId")
    private RolFuncionarioEntity rolFuncionario;

    /**
     * Estado del rol administrativo.
     */
    private Boolean estado;

    /**
     * Fecha de inicio del rol administrativo. Debe ser una fecha presente o futura.
     */
    @FutureOrPresent
    private LocalDate fechaInicio;

    /**
     * Fecha de finalización del rol administrativo. Debe ser una fecha presente o futura.
     */
    @FutureOrPresent
    private LocalDate fechaFin;

}
