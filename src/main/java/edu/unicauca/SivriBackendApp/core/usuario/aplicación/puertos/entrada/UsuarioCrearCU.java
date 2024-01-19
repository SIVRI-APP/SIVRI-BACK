package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;

/**
 * La interfaz UsuarioCrearCU define el puerto de entrada para la creación de usuarios.
 */
public interface UsuarioCrearCU {

    /**
     * Crea un nuevo usuario.
     *
     * @param usuario Objeto Usuario que contiene la información del nuevo usuario.
     * @return Respuesta que indica si la creación del usuario fue exitosa o no.
     */
    Respuesta<Boolean> crearUsuario(Usuario usuario);
}
