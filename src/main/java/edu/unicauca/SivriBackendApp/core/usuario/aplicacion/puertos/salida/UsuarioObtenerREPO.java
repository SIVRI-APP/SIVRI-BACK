package edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioListarConFiltroProyeccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


/**
 * La interfaz UsuarioObtenerREPO define el puerto de salida para obtener información
 * relacionada con usuarios desde el repositorio de persistencia.
 */
public interface UsuarioObtenerREPO {

    /**
     * Verifica la existencia de un usuario por su correo electrónico, tipo de documento y número de documento.
     *
     * @param correo          Correo electrónico del usuario.
     * @param tipoDocumento   Tipo de documento del usuario.
     * @param numeroDocumento Número de documento del usuario.
     * @return True si existe un usuario con los parámetros dados, de lo contrario, False.
     */
    boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento);

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
     * @param organismoDeInvestigacionId        Filtro por identificador de grupo.
     * @return Página que contiene la lista de solicitudes de usuario con proyecciones específicas.
     */
    Page<UsuarioListarConFiltroProyeccion> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario, Integer organismoDeInvestigacionId);

    /**
     * Obtiene información detallada de una solicitud de usuario.
     *
     * @param usuarioId Identificador único de la solicitud de usuario.
     * @return Optional que contiene información detallada de la solicitud de usuario si existe, o un Optional vacío si no existe.
     */
    Optional<UsuarioInformacionDetalladaProyeccion> obtenerUsuarioInformacionDetallada(long usuarioId);

    /**
     * Obtiene una solicitud de usuario por su identificador único.
     *
     * @param usuarioId Identificador único de la solicitud de usuario.
     * @return Optional que contiene la solicitud de usuario obtenida si existe, o un Optional vacío si no existe.
     */
    Optional<Usuario> obtenerUsuario(long usuarioId);

}
