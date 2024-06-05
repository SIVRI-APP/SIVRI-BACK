package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificacionDeUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioSolicitudObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioSolicitudObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioSolicitudInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioSolicitudListarConFiltroProyeccion;
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
public class UsuarioSolicitudObtenerService implements UsuarioSolicitudObtenerCU {

    private final UsuarioSolicitudObtenerREPO usuarioSolicitudObtenerREPO;
    private final ServicioDeIdentificacionDeUsuario servicioDeIdentificacionDeUsuario;

    /**
     * @see UsuarioSolicitudObtenerCU#listarConFiltro(int, int, String, TipoDocumento, String, String, String, TipoUsuario, EstadoSolicitudUsuario)
     */
    @Override
    public Respuesta<Page<UsuarioSolicitudListarConFiltroProyeccion>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombre, String apellido, TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        // Esta variable indica si se deben listar todas las solicitudes o solo las pertenecientes a un usuario
        Long buscarPorElUsuarioQueCreoLaSolicitud;

        // Si es un funcionario vamos a listar todas las solicitudes de lo contrario listamos solo las que el usuario solicito
        if (servicioDeIdentificacionDeUsuario.esFuncionario()){
            buscarPorElUsuarioQueCreoLaSolicitud = null;
        }else{
            buscarPorElUsuarioQueCreoLaSolicitud = servicioDeIdentificacionDeUsuario.obtenerUsuario().getId();
        }

        Page<UsuarioSolicitudListarConFiltroProyeccion> respuestaBd = usuarioSolicitudObtenerREPO.listarConFiltro(pageable, correo, tipoDocumento, numeroDocumento, nombre, apellido, tipoUsuario, estado, buscarPorElUsuarioQueCreoLaSolicitud);
        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }

    /**
     * @see UsuarioSolicitudObtenerCU#obtenerSolicitudUsuarioInformacionDetallada(long)
     */
    @Override
    public Respuesta<UsuarioSolicitudInformacionDetalladaProyeccion> obtenerSolicitudUsuarioInformacionDetallada(long solicitudUsuarioId) {
        UsuarioSolicitudInformacionDetalladaProyeccion respuestaBd = usuarioSolicitudObtenerREPO.obtenerSolicitudUsuarioInformacionDetallada(solicitudUsuarioId).orElseThrow(
                () -> new ReglaDeNegocioException("bad.solicitud.no.existe", List.of(Long.toString(solicitudUsuarioId))));

        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }

}

