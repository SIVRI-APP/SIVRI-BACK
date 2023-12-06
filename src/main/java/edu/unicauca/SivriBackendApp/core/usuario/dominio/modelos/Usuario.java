package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import lombok.Data;

@Data
public class Usuario {

    private Long id;

    private String correo;

    private TipoDocumento tipoDocumento;

    private String numeroDocumento;

    private Sexo sexo;

    private TipoUsuario tipoUsuario;

    private String nombres;

    private String apellidos;

    private String telefono;

    private String cvLac;

}
