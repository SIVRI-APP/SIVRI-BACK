package edu.unicauca.SivriBackendApp.core.usuario.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;

public interface UsuarioCrearCU {
    Respuesta guardar(Usuario usuario);
}
