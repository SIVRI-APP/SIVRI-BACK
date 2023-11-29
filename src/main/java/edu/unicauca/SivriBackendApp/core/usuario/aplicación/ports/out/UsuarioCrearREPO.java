package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.Usuario;

public interface UsuarioCrearREPO {
    Usuario registrarUsuario(Usuario usuario);
}
