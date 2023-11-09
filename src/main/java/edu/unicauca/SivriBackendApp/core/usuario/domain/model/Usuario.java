package edu.unicauca.SivriBackendApp.core.usuario.domain.model;

import lombok.Data;

@Data
public class Usuario {

    private Long id;

    private String correo;

    private String contraseña;

    private TipoDocumento tipoDocumento;

    private String numeroDocumento;

    private Sexo sexo;

    private EstadoUsuario estado;

    private TipoUsuario tipoUsuario;

    private String nombres;

    private String apellidos;

    private String telefono;

    private String cvLac;

}
