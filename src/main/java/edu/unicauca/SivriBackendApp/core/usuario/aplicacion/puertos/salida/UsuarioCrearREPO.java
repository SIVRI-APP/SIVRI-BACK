package edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;

/**
 * La interfaz UsuarioCrearREPO define el puerto de salida para la creación y actualización
 * de usuarios en el repositorio de persistencia.
 */
public interface UsuarioCrearREPO {

    /**
     * Crea una nueva solicitud de usuario en el repositorio de persistencia.
     *
     * @param usuario {@link Usuario}
     * @return {@link Respuesta}
     */
    Usuario crearUsuario(Usuario usuario);

}
