package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * Adaptador de salida que implementa el puerto de obtención de usuario.
 * Esta implementación utiliza un repositorio de Usuario y un mapeo para convertir entre modelos y entidades.
 */
@Component
@AllArgsConstructor
public class UsuarioObtenerAdapter implements UsuarioObtenerREPO {

    /**
     * Repositorio de Usuario que proporciona el acceso a la capa de persistencia.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Mapeo que convierte entre modelos y entidades de Usuario.
     */
    private final UsuarioInfraMapper usuarioInfraMapper;

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

    @Override
    public Page<UsuarioListarConFiltroProyeccion> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario, Integer organismoDeInvestigacionId) {

        String tipoDoc = (tipoDocumento != null) ? tipoDocumento.toString() : null;
        String tipoUsu = (tipoUsuario != null) ? tipoUsuario.toString() : null;

        return usuarioRepository.listarConFiltro(correo, tipoDoc, numeroDocumento, nombres, apellidos, tipoUsu, pageable);

        // TODO : Que pasa cuando quiero filtrar por un organismo de investigacion especifico
    }

    @Override
    public Optional<UsuarioInformacionDetalladaProyeccion> obtenerUsuarioInformacionDetallada(long usuarioId) {
        return usuarioRepository.obtenerUsuarioInformacionDetallada(usuarioId);
    }

    @Override
    public Optional<UsuarioInformacionDetalladaProyeccion> obtenerUsuarioInformacionDetalladaPorDocumento(long usuarioNumDoc, TipoDocumento tipoDocumento) {
        return usuarioRepository.obtenerUsuarioInformacionDetalladaPorDocumento(usuarioNumDoc, tipoDocumento.toString());
    }

    @Override
    public Optional<Usuario> obtenerUsuario(long usuarioId) {
        Optional<UsuarioEntity> respuestaBd = usuarioRepository.findById(usuarioId);

        if (respuestaBd.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(usuarioInfraMapper.toModel(respuestaBd.get()));
    }
}

