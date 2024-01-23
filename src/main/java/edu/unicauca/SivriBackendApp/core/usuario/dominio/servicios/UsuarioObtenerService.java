package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioListarConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioObtenerREPO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * El servicio UsuarioObtenerService implementa la lógica para obtener información de usuarios
 * desde el repositorio de persistencia, incluyendo la recuperación de un usuario por su ID
 * y la obtención de una lista paginada de usuarios filtrados.
 */
@Service
@AllArgsConstructor
public class UsuarioObtenerService implements UsuarioObtenerCU {

    private final UsuarioObtenerREPO usuarioObtenerREPO;

    /**
     * Obtiene un usuario por su ID.
     *
     * @param usuarioId Identificador único del usuario.
     * @return Respuesta que contiene el usuario obtenido.
     * @throws ReglaDeNegocioException Si no se encuentra el usuario con el ID especificado.
     */
    @Override
    public Respuesta<Usuario> obtenerUsuario(long usuarioId) {
        Usuario respuestaBd = usuarioObtenerREPO.obtenerUsuario(usuarioId).orElseThrow(
                () -> new ReglaDeNegocioException("bad.no.se.encontró.usuario.id", List.of(Long.toString(usuarioId))));

        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }

    /**
     * Lista usuarios de forma paginada y filtrada según los parámetros especificados.
     *
     * @param pageNo          Número de página.
     * @param pageSize        Tamaño de la página.
     * @param correo          Correo electrónico del usuario.
     * @param tipoDocumento   Tipo de documento del usuario.
     * @param numeroDocumento Número de documento del usuario.
     * @param nombres         Nombres del usuario.
     * @param apellidos       Apellidos del usuario.
     * @param tipoUsuario     Tipo de usuario.
     * @return Respuesta que contiene la lista paginada de usuarios según los filtros aplicados.
     */
    @Override
    public Respuesta<Page<List<UsuarioListarConFiltroProyección>>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<List<UsuarioListarConFiltroProyección>> respuestaBd = usuarioObtenerREPO.listarConFiltro(pageable, correo, tipoDocumento, numeroDocumento, nombres, apellidos, tipoUsuario);

        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }
}

