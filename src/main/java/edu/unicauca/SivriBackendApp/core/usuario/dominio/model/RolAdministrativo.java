package edu.unicauca.SivriBackendApp.core.usuario.dominio.model;

import java.time.LocalDate;

public class RolAdministrativo {

    Long id;

    private Funcionario funcionario;

    private RolFuncionario rolFuncionario;

    private Boolean estado;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}