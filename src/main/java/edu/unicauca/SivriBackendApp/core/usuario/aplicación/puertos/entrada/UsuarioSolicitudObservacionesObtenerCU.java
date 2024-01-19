package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudObservaciónListarProyección;
import org.springframework.data.domain.Page;

/**
 * La interfaz UsuarioSolicitudObservacionesObtenerCU define los puertos de entrada para obtener
 * información relacionada con observaciones de solicitudes de usuario.
 */
public interface UsuarioSolicitudObservacionesObtenerCU {

    /**
     * Obtiene una página de observaciones asociadas a una solicitud de usuario.
     *
     * @param pageNo             Número de página.
     * @param pageSize           Tamaño de página.
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return Respuesta que contiene una página de observaciones con proyecciones específicas.
     */
    Respuesta<Page<UsuarioSolicitudObservaciónListarProyección>> listar(int pageNo, int pageSize, long solicitudUsuarioId);

    /**
     * Obtiene la cantidad de observaciones pendientes para una solicitud de usuario.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return Respuesta que contiene la cantidad de observaciones pendientes.
     */
    Respuesta<Integer> solicitudConObservacionesPendientes(long solicitudUsuarioId);

    /**
     * Verifica si existe una solicitud de usuario por su identificador único.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return Respuesta que indica si existe una solicitud de usuario con el identificador dado.
     */
    Respuesta<Boolean> existePorId(long solicitudUsuarioId);

}
