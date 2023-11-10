package edu.unicauca.SivriBackendApp.core.usuario.domain.port.out;


import edu.unicauca.SivriBackendApp.core.usuario.domain.model.UsuarioSolicitud;

public interface UsuariosSolicitudCrearREPO {
    UsuarioSolicitud save(UsuarioSolicitud usuario);
}
