package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudInformaciónDetalladaProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudListarConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad.UsuarioSolicitudEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioSolicitudInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorio.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Adaptador de salida que implementa los puertos de obtención de solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitud y un mapeador de infraestructura para acceder a la capa de persistencia.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudObtenerAdapter implements UsuarioSolicitudObtenerREPO {

    /**
     * Repositorio de UsuarioSolicitud que proporciona el acceso a la capa de persistencia.
     */
    private final UsuarioSolicitudRepository usuarioSolicitudRepository;

    /**
     * Mapeador de infraestructura para convertir entre entidades y modelos de UsuarioSolicitud.
     */
    private final UsuarioSolicitudInfraMapper usuarioSolicitudInfraMapper;

    /**
     * Verifica si existe una solicitud de usuario con el correo, tipo de documento y número de documento especificados.
     *
     * @param correo           Correo de la solicitud de usuario.
     * @param tipoDocumento    Tipo de documento de la solicitud de usuario.
     * @param numeroDocumento  Número de documento de la solicitud de usuario.
     * @return true si existe una solicitud de usuario con los parámetros especificados, false de lo contrario.
     */
    @Override
    public boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento) {
        return usuarioSolicitudRepository.existsByCorreoOrTipoDocumentoAndNumeroDocumento(correo, tipoDocumento, numeroDocumento);
    }

    /**
     * Lista las solicitudes de usuario con filtros opcionales paginados.
     *
     * @param pageable      Objeto Pageable para la paginación.
     * @param correo        Correo de la solicitud de usuario.
     * @param tipoDocumento Tipo de documento de la solicitud de usuario.
     * @param numeroDocumento Número de documento de la solicitud de usuario.
     * @param nombres       Nombres de la solicitud de usuario.
     * @param apellidos     Apellidos de la solicitud de usuario.
     * @param tipoUsuario   Tipo de usuario de la solicitud.
     * @param estado        Estado de la solicitud de usuario.
     * @param grupoId       ID del grupo al que pertenece la solicitud de usuario.
     * @return Página de solicitudes de usuario que cumplen con los filtros especificados.
     */
    @Override
    public Page<UsuarioSolicitudListarConFiltroProyección> listarConFiltro(
            Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos,
            TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado, Integer grupoId) {

        String tipoDoc = (tipoDocumento != null) ? tipoDocumento.toString() : null;
        String tipoUsu = (tipoUsuario != null) ? tipoUsuario.toString() : null;
        String estadoUsu = (estado != null) ? estado.toString() : null;

        return usuarioSolicitudRepository.listarConFiltro(correo, tipoDoc, numeroDocumento, nombres, apellidos, tipoUsu, estadoUsu, grupoId, pageable);
    }

    /**
     * Obtiene la información detallada de una solicitud de usuario con el identificador proporcionado.
     *
     * @param solicitudUsuarioId Identificador de la solicitud de usuario.
     * @return Información detallada de la solicitud de usuario.
     */
    @Override
    public Optional<UsuarioSolicitudInformaciónDetalladaProyección> obtenerSolicitudUsuarioInformaciónDetallada(long solicitudUsuarioId) {
        return usuarioSolicitudRepository.obtenerSolicitudUsuario(solicitudUsuarioId);
    }

    /**
     * Obtiene una solicitud de usuario con el identificador proporcionado.
     *
     * @param solicitudUsuarioId Identificador de la solicitud de usuario.
     * @return Solicitud de usuario correspondiente al identificador proporcionado, o vacío si no se encuentra.
     */
    @Override
    public Optional<UsuarioSolicitud> obtenerSolicitudUsuario(long solicitudUsuarioId) {
        Optional<UsuarioSolicitudEntity> respuestaBd = usuarioSolicitudRepository.findById(solicitudUsuarioId);

        if (respuestaBd.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(usuarioSolicitudInfraMapper.toModel(respuestaBd.get()));
    }
}

