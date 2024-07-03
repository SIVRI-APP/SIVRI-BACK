package edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudListarConFiltroProyeccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


/**
 * La interfaz UsuarioSolicitudObtenerREPO define el puerto de salida para obtener información
 * relacionada con solicitudes de usuarios desde el repositorio de persistencia.
 */
public interface UsuarioSolicitudObtenerREPO {

    /**
     * Obtiene una página de solicitudes de usuarios filtradas según los parámetros proporcionados.
     *
     * @param pageable              Objeto Pageable que representa la información de paginación.
     * @param correo                Filtro por correo del usuario.
     * @param tipoDocumento         Filtro por tipo de documento del usuario.
     * @param numeroDocumento       Filtro por número de documento del usuario.
     * @param nombres               Filtro por nombres del usuario.
     * @param apellidos             Filtro por apellidos del usuario.
     * @param tipoUsuario           Filtro por tipo de usuario.
     * @param estado                Filtro por estado de la solicitud de usuario.
     * @param creadoPorUsuarioId    Filtro solo las solicitudes creadas por un usuario
     * @return {@link UsuarioSolicitud}
     */
    Page<UsuarioSolicitudListarConFiltroProyeccion> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado, Long creadoPorUsuarioId);

    /**
     * Obtiene información detallada de una solicitud de usuario.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return {@link UsuarioSolicitud}
     */
    Optional<UsuarioSolicitudInformacionDetalladaProyeccion> obtenerSolicitudUsuarioInformacionDetallada(long solicitudUsuarioId);

    /**
     * Obtiene la solicitud de usuario por Id.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return {@link UsuarioSolicitud}
     */
    Optional<UsuarioSolicitud> obtenerSolicitudUsuarioPorId(Long solicitudUsuarioId);

    /**
     * Valida si una solicitud de usuario contiene observaciones
     *
     * @param solicitudUsuarioId Id de la solicitud de usuario a consultar
     * @return true si existe una observacion para esta solicitud
     */
    Boolean solicitudTieneObservaciones(Long solicitudUsuarioId);
}
