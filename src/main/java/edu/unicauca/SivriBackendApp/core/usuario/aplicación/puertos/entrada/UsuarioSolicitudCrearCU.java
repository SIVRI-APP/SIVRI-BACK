package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada.RechazarSolicitudDTO;

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
     * Aprueba una solicitud de usuario.
     *
     * @param solicitudId Identificador único de la solicitud de usuario.
     * @return Respuesta que indica si la aprobación de la solicitud de usuario fue exitosa o no.
     */
    Respuesta<Boolean> aprobarSolicitudUsuario(long solicitudId);

    /**
     * Rechaza y agrega una observacion a una solicitud de usuario.
     *
     * @param rechazarSolicitud Información necesaria para crear la observacion de la solicitud.
     * @return Respuesta que indica si la aprobación de la solicitud de usuario fue exitosa o no.
     */
    Respuesta<Boolean> rechazarSolicitudUsuario(RechazarSolicitudDTO rechazarSolicitud);
}
