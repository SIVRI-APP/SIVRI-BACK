package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioSolicitudEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adaptador de salida que implementa el puerto de creación y actualización de solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitud y un Mapper para convertir entre modelos y entidades.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudEliminarAdapter implements UsuarioSolicitudEliminarREPO {

    /** Repositorio */
    private final UsuarioSolicitudRepository usuarioSolicitudRepository;


    /**
     * @see UsuarioSolicitudEliminarREPO#eliminarSolicitudUsuario(Long)
     */
    @Override
    public void eliminarSolicitudUsuario(Long usuarioSolicitudId) {
        usuarioSolicitudRepository.deleteById(usuarioSolicitudId);
    }
}
