package edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

/**
 * La interfaz UsuarioSolicitudObservacionCrearCU define los puertos de entrada para la creación, edición,
 * aprobación y gestión de observaciones de solicitudes de usuarios.
 */
public interface UsuarioSolicitudObservacionCrearCU {

    /**
     * Resolver una Observacion.
     *
     * @param observacionId Id de la observacion
     * @return {@link Respuesta}
     */
    Respuesta<Boolean> resolverObservacion(Long observacionId);

}
