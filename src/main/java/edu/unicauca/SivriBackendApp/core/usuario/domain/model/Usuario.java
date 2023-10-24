package edu.unicauca.SivriBackendApp.core.usuario.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Usuario {

    private String numeroDocumento;

    private TipoDocumento tipoDocumento;

    private Sexo sexo;

    private EstadoUsuario estado;

    private String nombres;

    private String apellidos;

    private String telefono;

    private String correo;

    private String contraseña;

    private List<RolUsuario> rolesDeUsuario;

//    @OneToMany(mappedBy="usuario", cascade = CascadeType.REMOVE)
//    private List<IntegranteProyectoEntity> participacionProyectos;
}
