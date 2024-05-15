package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada.RechazarSolicitudDTO;

/**
 * La interfaz UsuarioSolicitudObservacionesObtenerCU define los puertos de entrada para obtener
 * información relacionada con observaciones de solicitudes de usuario.
 */
public interface UsuarioSolicitudObservacionesCrearCU {

    /**
     * Crea una observacion para una solicitud de Usuaio.
     *
     * @param rechazarSolicitud Información necesaria para rechazar una solicitud
     * @return Respuesta que contiene la cantidad de observaciones pendientes.
     */
    Respuesta<Boolean> crearObservacionSolicitudUsuario(RechazarSolicitudDTO rechazarSolicitud);


}
