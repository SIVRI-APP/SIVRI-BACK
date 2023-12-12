package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;

public interface UsuarioSolicitudCrearREPO {
    UsuarioSolicitud crearUsuarioSolicitud(UsuarioSolicitud usuario);

    UsuarioSolicitud actualizarUsuarioSolicitud(UsuarioSolicitud usuario);
}
