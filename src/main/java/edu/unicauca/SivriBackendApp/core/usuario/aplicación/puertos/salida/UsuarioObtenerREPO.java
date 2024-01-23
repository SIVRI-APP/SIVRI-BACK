package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioListarConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * La interfaz UsuarioObtenerREPO define el puerto de salida para obtener información
 * relacionada con usuarios desde el repositorio de persistencia.
 */
public interface UsuarioObtenerREPO {

    /**
     * Obtiene un usuario por su identificador único.
     *
     * @param usuarioId Identificador único del usuario.
     * @return Optional que contiene el Usuario si existe, o un Optional vacío si no existe.
     */
    Optional<Usuario> obtenerUsuario(long usuarioId);

    /**
     * Obtiene la entidad de usuario asociada a un correo electrónico.
     *
     * @param correo Correo electrónico del usuario.
     * @return Optional que contiene la entidad Usuario si existe, o un Optional vacío si no existe.
     */
    Optional<UsuarioEntity> obtenerEntidadUsuarioPorCorreo(String correo);

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
     * Obtiene una página de usuarios filtrados según los parámetros proporcionados.
     *
     * @param pageable       Objeto Pageable que representa la información de paginación.
     * @param correo         Filtro por correo del usuario.
     * @param tipoDocumento  Filtro por tipo de documento del usuario.
     * @param numeroDocumento Filtro por número de documento del usuario.
     * @param nombres        Filtro por nombres del usuario.
     * @param apellidos      Filtro por apellidos del usuario.
     * @param tipoUsuario    Filtro por tipo de usuario.
     * @return Página que contiene la lista de usuarios con proyecciones específicas.
     */
    Page<List<UsuarioListarConFiltroProyección>> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario);

}
