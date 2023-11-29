package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.Usuario;

public interface UsuarioCrearCU {
    Respuesta registrarUsuario(Usuario usuario);
}
