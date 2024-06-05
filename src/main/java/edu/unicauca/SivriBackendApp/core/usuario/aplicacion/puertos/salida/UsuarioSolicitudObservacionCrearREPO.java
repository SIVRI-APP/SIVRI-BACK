package edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;

/**
 * La interfaz UsuarioSolicitudCrearREPO define el puerto de salida para la creación y actualización
 * de solicitudes de usuarios en el repositorio de persistencia.
 */
public interface UsuarioSolicitudObservacionCrearREPO {

    /**
     * Crea una observacion para rechazar la solicitud de un Usuario y añade un prompt a la conversacion
     *
     * @param usuarioSolicitudObservaciones {@link UsuarioSolicitudObservaciones}
     */
    void crearObservacion(UsuarioSolicitudObservaciones usuarioSolicitudObservaciones);

    /**
     * Cambia el estado de la observacion
     *
     * @param observacionId Id de la observacion
     */
    void cambiarEstado(Long observacionId);

}
