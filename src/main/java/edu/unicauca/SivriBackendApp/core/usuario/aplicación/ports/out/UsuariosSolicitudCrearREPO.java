package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.UsuarioSolicitud;

public interface UsuariosSolicitudCrearREPO {
    UsuarioSolicitud save(UsuarioSolicitud usuario);
}
