package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioListarConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorio.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


/**
 * Adaptador de salida que implementa el puerto de obtención de usuario.
 * Esta implementación utiliza un repositorio de Usuario y un mapeador para convertir entre modelos y entidades.
 */
@Component
@AllArgsConstructor
public class UsuarioObtenerAdapter implements UsuarioObtenerREPO {

    /**
     * Repositorio de Usuario que proporciona el acceso a la capa de persistencia.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Mapeador que convierte entre modelos y entidades de Usuario.
     */
    private final UsuarioInfraMapper usuarioInfraMapper;

    /**
     * Obtiene un usuario por su identificador único.
     *
     * @param usuarioId Identificador único del usuario.
     * @return Un Optional que puede contener el usuario correspondiente o estar vacío si no se encuentra.
     */
    @Override
    public Optional<Usuario> obtenerUsuario(long usuarioId) {
        Optional<UsuarioEntity> respuestaBd = usuarioRepository.findById(usuarioId);

        if (respuestaBd.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(usuarioInfraMapper.toModel(respuestaBd.get()));
    }

    /**
     * Obtiene la entidad de usuario por su dirección de correo electrónico.
     *
     * @param correo Dirección de correo electrónico del usuario.
     * @return Un Optional que puede contener la entidad de usuario correspondiente o estar vacío si no se encuentra.
     */
    @Override
    public Optional<UsuarioEntity> obtenerEntidadUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    /**
     * Verifica si existe un usuario por correo, tipo de documento y número de documento.
     *
     * @param correo Dirección de correo electrónico del usuario.
     * @param tipoDocumento Tipo de documento del usuario.
     * @param numeroDocumento Número de documento del usuario.
     * @return `true` si existe un usuario con los parámetros dados, de lo contrario, `false`.
     */
    @Override
    public boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento) {
        return usuarioRepository.existsByCorreoOrTipoDocumentoAndNumeroDocumento(correo, tipoDocumento, numeroDocumento);
    }

    /**
     * Lista usuarios con un filtro específico y paginación.
     *
     * @param pageable Información sobre la paginación.
     * @param correo Dirección de correo electrónico del usuario.
     * @param tipoDocumento Tipo de documento del usuario.
     * @param numeroDocumento Número de documento del usuario.
     * @param nombres Nombres del usuario.
     * @param apellidos Apellidos del usuario.
     * @param tipoUsuario Tipo de usuario.
     * @return Una página que contiene la lista de usuarios filtrada y paginada.
     */
    @Override
    public Page<List<UsuarioListarConFiltroProyección>> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario) {

        String tipoDoc = (tipoDocumento != null) ? tipoDocumento.toString() : null;
        String tipoUsu = (tipoUsuario != null) ? tipoUsuario.toString() : null;

        return usuarioRepository.listarConFiltro(correo, tipoDoc, numeroDocumento, nombres, apellidos, tipoUsu, pageable);
    }
}

