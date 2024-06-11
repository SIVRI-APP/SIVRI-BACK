package edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada.EnviarParaRevisionDTO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada.RechazarSolicitudDTO;

/**
 * La interfaz UsuarioSolicitudCrearCU define los puertos de entrada para la creación, edición,
 * aprobación y gestión de solicitudes de usuarios.
 */
public interface UsuarioSolicitudCrearCU {

    /**
     * Crea una nueva solicitud de usuario.
     *
     * @param usuario {@link UsuarioSolicitud}
     * @return {@link Respuesta}
     */
    Respuesta<Boolean> crearSolicitudUsuario(UsuarioSolicitud usuario);

    /**
     * Aprueba la solicitud de un Usuario
     *
     * @param solicitudUsuarioId Id de la solicitud de un usuario
     * @return {@link Respuesta}
     */
    Respuesta<Boolean> aprobarSolicitudUsuario(Long solicitudUsuarioId);

    /**
     * Rechaza la solicitud de un Usuario y añade un prompt a la conversacion
     *
     * @param rechazarSolicitudDTO {@link RechazarSolicitudDTO}
     * @return {@link Respuesta}
     */
    Respuesta<Boolean> rechazarSolicitudUsuario(RechazarSolicitudDTO rechazarSolicitudDTO);

    /**
     * Envía una solicitud a revision VRI
     *
     * @param enviarParaRevisionDTO {@link EnviarParaRevisionDTO}
     * @return {@link Respuesta}
     */
    Respuesta<Boolean> enviarParaRevision(EnviarParaRevisionDTO enviarParaRevisionDTO);
}
