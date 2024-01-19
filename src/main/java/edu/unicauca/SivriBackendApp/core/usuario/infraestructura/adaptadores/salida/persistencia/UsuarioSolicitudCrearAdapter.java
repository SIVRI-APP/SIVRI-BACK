package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioSolicitudInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorio.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adaptador de salida que implementa el puerto de creación y actualización de solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitud y un mapeador para convertir entre modelos y entidades.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudCrearAdapter implements UsuarioSolicitudCrearREPO {

    /**
     * Repositorio de UsuarioSolicitud que proporciona el acceso a la capa de persistencia.
     */
    private final UsuarioSolicitudRepository usuarioSolicitudRepository;

    /**
     * Mapeador que convierte entre modelos y entidades de UsuarioSolicitud.
     */
    private final UsuarioSolicitudInfraMapper usuarioSolicitudInfraMapper;

    /**
     * Crea una nueva solicitud de usuario en la capa de persistencia.
     *
     * @param usuario Solicitud de usuario a crear.
     * @return La solicitud de usuario creada y convertida a modelo.
     */
    @Override
    public UsuarioSolicitud crearUsuarioSolicitud(UsuarioSolicitud usuario) {
        return usuarioSolicitudInfraMapper.toModel(usuarioSolicitudRepository.save(usuarioSolicitudInfraMapper.toEntity(usuario)));
    }

    /**
     * Actualiza una solicitud de usuario existente en la capa de persistencia.
     *
     * @param usuario Solicitud de usuario a actualizar.
     * @return La solicitud de usuario actualizada y convertida a modelo.
     */
    @Override
    public UsuarioSolicitud actualizarUsuarioSolicitud(UsuarioSolicitud usuario) {
        return usuarioSolicitudInfraMapper.toModel(usuarioSolicitudRepository.save(usuarioSolicitudInfraMapper.toEntity(usuario)));
    }
}
