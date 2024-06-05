package edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudConversacion;

/**
 * La interfaz UsuarioSolicitudCrearREPO define el puerto de salida para la creación y actualización
 * de solicitudes de usuarios en el repositorio de persistencia.
 */
public interface UsuarioSolicitudConversacionCrearREPO {

    /**
     * Crea una conversacion sobre una observacion para rechazar la solicitud de un Usuario y añade un prompt a la conversacion
     *
     * @param usuarioSolicitudConversacion {@link UsuarioSolicitudConversacion}
     */
    void agregarConversacion(UsuarioSolicitudConversacion usuarioSolicitudConversacion);

}
