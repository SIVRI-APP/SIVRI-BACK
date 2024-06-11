package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioListarConFiltroProyeccion;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * El servicio UsuarioSolicitudObtenerService implementa la lógica de negocio para la obtención
 * y filtrado de solicitudes de usuario.
 */
@Service
@AllArgsConstructor
public class UsuarioObtenerService implements UsuarioObtenerCU {

    private final UsuarioObtenerREPO usuarioObtenerREPO;

    /**
     * Lista las solicitudes de usuario filtradas y paginadas.
     *
     * @param pageNo            Número de la página.
     * @param pageSize          Tamaño de la página.
     * @param correo            Correo del usuario.
     * @param tipoDocumento     Tipo de documento del usuario.
     * @param numeroDocumento   Número de documento del usuario.
     * @param nombre            Nombres del usuario.
     * @param apellido          Apellidos del usuario.
     * @param tipoUsuario       Tipo de usuario.
     * @param organismoDeInvestigacionId           Identificador del grupo.
     * @return Respuesta que contiene la lista paginada de solicitudes de usuario filtradas.
     */
    @Override
    public Respuesta<Page<UsuarioListarConFiltroProyeccion>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombre, String apellido, TipoUsuario tipoUsuario, Integer organismoDeInvestigacionId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<UsuarioListarConFiltroProyeccion> respuestaBd = usuarioObtenerREPO.listarConFiltro(pageable, correo, tipoDocumento, numeroDocumento, nombre, apellido, tipoUsuario, organismoDeInvestigacionId);
        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<UsuarioInformacionDetalladaProyeccion> obtenerUsuarioInformacionDetallada(long usuarioId) {
        UsuarioInformacionDetalladaProyeccion respuestaBd = usuarioObtenerREPO.obtenerUsuarioInformacionDetallada(usuarioId).orElseThrow(
                () -> new ReglaDeNegocioException("bad.usuarios.no.existe", List.of(Long.toString(usuarioId))));

        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }

    /**
     * Obtiene una solicitud de usuario por su identificador.
     *
     * @param usuarioId Identificador de la solicitud de usuario.
     * @return Respuesta que contiene la solicitud de usuario.
     * @throws ReglaDeNegocioException Si la solicitud de usuario no existe.
     */
    @Override
    public Respuesta<Usuario> obtenerUsuario(long usuarioId) {
        Usuario respuestaBd = usuarioObtenerREPO.obtenerUsuario(usuarioId).orElseThrow(
                () -> new ReglaDeNegocioException("bad.usuarios.no.existe", List.of(Long.toString(usuarioId))));

        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }

}

