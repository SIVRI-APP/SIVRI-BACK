package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import java.time.LocalDate;

/**
 * La clase RolAdministrativo representa el rol administrativo asignado a un funcionario en el sistema.
 */
public class RolAdministrativo {

    /**
     * Identificador único del rol administrativo.
     */
    Long id;

    /**
     * Funcionario al que se le asigna el rol administrativo.
     */
    private Funcionario funcionario;

    /**
     * Rol específico asignado al funcionario.
     */
    private RolFuncionario rolFuncionario;

    /**
     * Estado del rol administrativo (activo o inactivo).
     */
    private Boolean estado;

    /**
     * Fecha de inicio de la asignación del rol administrativo.
     */
    private LocalDate fechaInicio;

    /**
     * Fecha de fin de la asignación del rol administrativo (puede ser nula si el rol está vigente).
     */
    private LocalDate fechaFin;
}
