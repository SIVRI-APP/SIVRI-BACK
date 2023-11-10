package edu.unicauca.SivriBackendApp.core.usuario.domain.model;

import lombok.Data;

@Data
public class UsuarioSolicitudObservaciones {

    private Long id;

    private UsuarioSolicitud solicitudUsuario;

    private Funcionario funcionario;

    private String observacion;
}
