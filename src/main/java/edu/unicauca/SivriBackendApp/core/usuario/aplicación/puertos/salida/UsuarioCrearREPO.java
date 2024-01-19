package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;

/**
 * La interfaz UsuarioCrearREPO define el puerto de salida para la creación de usuarios
 * en el repositorio de persistencia.
 */
public interface UsuarioCrearREPO {

    /**
     * Crea un nuevo usuario en el repositorio de persistencia.
     *
     * @param usuario Objeto Usuario que contiene la información del nuevo usuario.
     * @return Objeto Usuario que representa al usuario creado.
     */
    Usuario crearUsuario(Usuario usuario);
}
