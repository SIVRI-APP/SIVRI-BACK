package edu.unicauca.SivriBackendApp.core.usuario.domain.port.out;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;

public interface UsuarioCrearREPO {
    Boolean solicitudCreacionDeUsuario (Usuario nuevoUsuario);
}
