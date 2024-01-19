package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorio.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adaptador de salida que implementa el puerto de creación de usuario.
 * Esta implementación utiliza un repositorio de Usuario y un mapeador para convertir entre modelos y entidades.
 */
@Component
@AllArgsConstructor
public class UsuarioCrearAdapter implements UsuarioCrearREPO {

    /**
     * Repositorio de Usuario que proporciona el acceso a la capa de persistencia.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Mapeador que convierte entre modelos y entidades de Usuario.
     */
    private final UsuarioInfraMapper usuarioInfraMapper;

    /**
     * Crea un nuevo usuario utilizando el repositorio de Usuario y el mapeador de UsuarioInfraMapper.
     *
     * @param usuario El objeto Usuario que se va a crear.
     * @return El Usuario creado y mapeado desde la entidad persistente.
     */
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioInfraMapper.toModel(usuarioRepository.save(usuarioInfraMapper.toEntity(usuario)));
    }
}
