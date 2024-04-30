package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

/**
 * La interfaz UsuarioSolicitudObservacionesObtenerCU define los puertos de entrada para obtener
 * información relacionada con observaciones de solicitudes de usuario.
 */
public interface UsuarioSolicitudObservacionesObtenerCU {

    /**
     * Obtiene la cantidad de observaciones pendientes para una solicitud de usuario.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return Respuesta que contiene la cantidad de observaciones pendientes.
     */
    Respuesta<Integer> solicitudConObservacionesPendientes(long solicitudUsuarioId);


}
