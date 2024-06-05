package edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;

/**
 * La interfaz UsuarioCrearREPO define el puerto de salida para la creación y actualización
 * de usuarios en el repositorio de persistencia.
 */
public interface UsuarioCrearREPO {

    /**
     * Crea una nueva solicitud de usuario en el repositorio de persistencia.
     *
     * @param usuario Objeto UsuarioSolicitud que contiene la información de la nueva solicitud.
     * @return Objeto UsuarioSolicitud que representa la solicitud de usuario creada.
     */
    Usuario crearUsuario(Usuario usuario);

}
