package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioSolicitudObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioSolicitudEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioSolicitudInfraSimpleMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioSolicitudObservacionesRepository;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * Adaptador de salida que implementa los puertos de obtención de solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitud y un Mapper de infraestructura para acceder a la capa de persistencia.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudObtenerAdapter implements UsuarioSolicitudObtenerREPO {

    /**
     * Repositorio de UsuarioSolicitud que proporciona el acceso a la capa de persistencia.
     */
    private final UsuarioSolicitudRepository usuarioSolicitudRepository;
    private final UsuarioSolicitudObservacionesRepository usuarioSolicitudObservacionesRepository;

    /**
     * Mapper
     */
    private final UsuarioSolicitudInfraSimpleMapper usuarioSolicitudInfraMapper;


    /**
     * @see UsuarioSolicitudObtenerREPO#listarConFiltro(Pageable, String, TipoDocumento, String, String, String, TipoUsuario, EstadoSolicitudUsuario, Long)
     */
    @Override
    public Page<UsuarioSolicitudListarConFiltroProyeccion> listarConFiltro(
            Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombre, String apellido,
            TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado, Long creadoPorUsuarioId) {

        String tipoDoc = (tipoDocumento != null) ? tipoDocumento.toString() : null;
        String tipoUsu = (tipoUsuario != null) ? tipoUsuario.toString() : null;
        String estadoUsu = (estado != null) ? estado.toString() : null;

        return usuarioSolicitudRepository.listarConFiltro(correo, tipoDoc, numeroDocumento, nombre, apellido, tipoUsu, estadoUsu, creadoPorUsuarioId, pageable);
    }

    /**
     * @see UsuarioSolicitudObtenerREPO#obtenerSolicitudUsuarioInformacionDetallada(long)
     */
    @Override
    public Optional<UsuarioSolicitudInformacionDetalladaProyeccion> obtenerSolicitudUsuarioInformacionDetallada(long solicitudUsuarioId) {
        return usuarioSolicitudRepository.obtenerSolicitudUsuarioInformacionDetallada(solicitudUsuarioId);
    }

    /**
     * @see UsuarioSolicitudObtenerREPO#obtenerSolicitudUsuarioPorId(Long)
     */
    @Override
    public Optional<UsuarioSolicitud> obtenerSolicitudUsuarioPorId(Long solicitudUsuarioId) {
        Optional<UsuarioSolicitud> respuesta = Optional.empty();
        Optional<UsuarioSolicitudEntity> respuestaBD = usuarioSolicitudRepository.findById(solicitudUsuarioId);

        if (respuestaBD.isPresent()){
            respuesta = Optional.of(usuarioSolicitudInfraMapper.toModelCompleto(respuestaBD.get()));
        }

        return respuesta;
    }

    /**
     * @see UsuarioSolicitudObtenerREPO#solicitudTieneObservaciones(Long)
     */
    @Override
    public Boolean solicitudTieneObservaciones(Long solicitudUsuarioId) {
        return usuarioSolicitudObservacionesRepository.existsBySolicitudUsuarioId(solicitudUsuarioId);
    }

}

