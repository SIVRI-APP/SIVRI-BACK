package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioInfraSimpleMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adaptador de salida que implementa el puerto de creación y actualización de usuario.
 * Esta implementación utiliza un repositorio de Usuario y un Mapper para convertir entre modelos y entidades.
 */
@Component
@AllArgsConstructor
public class UsuarioCrearAdapter implements UsuarioCrearREPO {

    /** Repositorio */
    private final UsuarioRepository usuarioRepository;

    /** Mapper */
    private final UsuarioInfraSimpleMapper usuarioInfraSimpleMapper;

    /**
     * @see UsuarioCrearREPO#crearUsuario(Usuario)
     */
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioInfraSimpleMapper.toModel(usuarioRepository.save(usuarioInfraSimpleMapper.toEntity(usuario)));
    }
}
