package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudObservaciónListarProyección;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * La interfaz UsuarioSolicitudObservacionesObtenerREPO define el puerto de salida para obtener
 * información relacionada con observaciones de solicitudes de usuario desde el repositorio de persistencia.
 */
public interface UsuarioSolicitudObservacionesObtenerREPO {

    /**
     * Obtiene una página de observaciones asociadas a una solicitud de usuario.
     *
     * @param pageable           Objeto Pageable que representa la información de paginación.
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return Página que contiene la lista de observaciones con proyecciones específicas.
     */
    Page<UsuarioSolicitudObservaciónListarProyección> listar(Pageable pageable, long solicitudUsuarioId);

    /**
     * Obtiene la cantidad de observaciones pendientes para una solicitud de usuario.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return Cantidad de observaciones pendientes.
     */
    Integer solicitudConObservacionesPendientes(long solicitudUsuarioId);

    /**
     * Verifica si existe una solicitud de usuario por su identificador único.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return True si existe una solicitud de usuario con el identificador dado, de lo contrario, False.
     */
    Boolean existePorId(long solicitudUsuarioId);
}
