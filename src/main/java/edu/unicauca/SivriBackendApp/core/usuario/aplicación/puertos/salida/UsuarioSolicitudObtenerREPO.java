package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioSolicitudListarConFiltroProyección;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * La interfaz UsuarioSolicitudObtenerREPO define el puerto de salida para obtener información
 * relacionada con solicitudes de usuarios desde el repositorio de persistencia.
 */
public interface UsuarioSolicitudObtenerREPO {

    /**
     * Obtiene una página de solicitudes de usuarios filtradas según los parámetros proporcionados.
     *
     * @param pageable       Objeto Pageable que representa la información de paginación.
     * @param correo         Filtro por correo del usuario.
     * @param tipoDocumento  Filtro por tipo de documento del usuario.
     * @param numeroDocumento Filtro por número de documento del usuario.
     * @param nombres        Filtro por nombres del usuario.
     * @param apellidos      Filtro por apellidos del usuario.
     * @param tipoUsuario    Filtro por tipo de usuario.
     * @param estado         Filtro por estado de la solicitud de usuario.
     * @param organismoDeInvestigacionId        Filtro por identificador de grupo.
     * @return Página que contiene la lista de solicitudes de usuario con proyecciones específicas.
     */
    Page<UsuarioSolicitudListarConFiltroProyección> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado, Integer organismoDeInvestigacionId);
}
