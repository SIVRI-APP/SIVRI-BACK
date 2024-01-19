package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;

/**
 * La interfaz UsuarioSolicitudCrearCU define los puertos de entrada para la creación, edición,
 * aprobación y gestión de observaciones de solicitudes de usuarios.
 */
public interface UsuarioSolicitudCrearCU {

    /**
     * Crea una nueva solicitud de usuario.
     *
     * @param usuario Objeto UsuarioSolicitud que contiene la información de la nueva solicitud.
     * @return Respuesta que indica si la creación de la solicitud de usuario fue exitosa o no.
     */
    Respuesta<Boolean> crearSolicitudUsuario(UsuarioSolicitud usuario);

    /**
     * Devuelve una solicitud de usuario con observaciones.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @param observaciones      Observaciones asociadas a la solicitud.
     * @return Respuesta que indica si la operación de devolución con observaciones fue exitosa o no.
     */
    Respuesta<Boolean> devolverSolicitudConObservaciones(long solicitudUsuarioId, String observaciones);

    /**
     * Edita la información de una solicitud de usuario existente.
     *
     * @param solicitudId Identificador único de la solicitud de usuario.
     * @param usuario     Objeto UsuarioSolicitud que contiene la información actualizada.
     * @return Respuesta que indica si la edición de la solicitud de usuario fue exitosa o no.
     */
    Respuesta<Boolean> editarSolicitudUsuario(long solicitudId, UsuarioSolicitud usuario);

    /**
     * Aprueba una solicitud de usuario.
     *
     * @param solicitudId Identificador único de la solicitud de usuario.
     * @return Respuesta que indica si la aprobación de la solicitud de usuario fue exitosa o no.
     */
    Respuesta<Boolean> aprobarSolicitudUsuario(long solicitudId);
}
