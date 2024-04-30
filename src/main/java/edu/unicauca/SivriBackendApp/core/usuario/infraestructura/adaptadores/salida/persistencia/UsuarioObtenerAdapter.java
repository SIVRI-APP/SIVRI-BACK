package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


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
}

