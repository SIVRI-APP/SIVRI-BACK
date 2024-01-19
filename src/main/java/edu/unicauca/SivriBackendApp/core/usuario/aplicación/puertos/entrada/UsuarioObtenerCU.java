package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioListarConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * La interfaz UsuarioObtenerCU define los puertos de entrada para obtener información de usuarios,
 * incluyendo la obtención de un usuario específico y la lista de usuarios con filtros.
 */
public interface UsuarioObtenerCU {

    /**
     * Obtiene un usuario específico por su identificador único.
     *
     * @param usuarioId Identificador único del usuario.
     * @return Respuesta que contiene el usuario obtenido.
     */
    Respuesta<Usuario> obtenerUsuario(long usuarioId);

    /**
     * Obtiene una página de usuarios filtrados según los parámetros proporcionados.
     *
     * @param pageNo            Número de página.
     * @param pageSize          Tamaño de página.
     * @param correo            Filtro por correo del usuario.
     * @param tipoDocumento     Filtro por tipo de documento del usuario.
     * @param numeroDocumento   Filtro por número de documento del usuario.
     * @param nombres           Filtro por nombres del usuario.
     * @param apellidos         Filtro por apellidos del usuario.
     * @param tipoUsuario       Filtro por tipo de usuario.
     * @return Respuesta que contiene una página de usuarios con proyecciones específicas.
     */
    Respuesta<Page<List<UsuarioListarConFiltroProyección>>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario);
}
