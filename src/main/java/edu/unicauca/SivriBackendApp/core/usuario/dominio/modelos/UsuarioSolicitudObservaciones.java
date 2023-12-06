package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioSolicitudObservaciones {

    private Long id;

    private UsuarioSolicitud solicitudUsuario;

    private Funcionario funcionario;

    private String observación;

    private LocalDate fechaObservación;
}
