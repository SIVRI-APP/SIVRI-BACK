package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioSolicitudConversacionCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudConversacion;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioSolicitudConversacionInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioSolicitudConversacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adaptador de salida que implementa el puerto de creación y actualización de solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitud y un Mapper para convertir entre modelos y entidades.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudConversacionAdapter implements UsuarioSolicitudConversacionCrearREPO {

    /** Repositorio */
    private final UsuarioSolicitudConversacionRepository usuarioSolicitudConversacionRepository;

    /** Mapper */
    private final UsuarioSolicitudConversacionInfraMapper usuarioSolicitudConversacionInfraMapper;


    /**
     * @see UsuarioSolicitudConversacionCrearREPO#agregarConversacion(UsuarioSolicitudConversacion)
     */
    @Override
    public void agregarConversacion(UsuarioSolicitudConversacion usuarioSolicitudConversacion) {
        usuarioSolicitudConversacionRepository.save(usuarioSolicitudConversacionInfraMapper.toEntity(usuarioSolicitudConversacion));
    }
}
