package edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioSolicitudInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioSolicitudListarConFiltroProyeccion;
import org.springframework.data.domain.Page;

/**
 * La interfaz UsuarioSolicitudObtenerCU define los puertos de entrada para obtener información
 * relacionada con solicitudes de usuarios.
 */
public interface UsuarioSolicitudObtenerCU {

    /**
     * Obtiene una página de solicitudes de usuarios filtradas según los parámetros proporcionados.
     *
     * @param pageNo            Número de página.
     * @param pageSize          Tamaño de página.
     * @param correo            Filtro por correo del usuario.
     * @param tipoDocumento     Filtro por tipo de documento del usuario.
     * @param numeroDocumento   Filtro por número de documento del usuario.
     * @param nombres           Filtro por nombres del usuario.
     * @param apellidos         Filtro por apellidos del usuario.
     * @param tipoUsuario       Filtro por tipo de usuario.
     * @param estado            Filtro por estado de la solicitud de usuario.
     * @return Respuesta que contiene una página de solicitudes de usuario con proyecciones específicas.
     */
    Respuesta<Page<UsuarioSolicitudListarConFiltroProyeccion>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado);

    /**
     * Obtiene información detallada de una solicitud de usuario.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return Respuesta que contiene información detallada de la solicitud de usuario.
     */
    Respuesta<UsuarioSolicitudInformacionDetalladaProyeccion> obtenerSolicitudUsuarioInformacionDetallada(long solicitudUsuarioId);


}
