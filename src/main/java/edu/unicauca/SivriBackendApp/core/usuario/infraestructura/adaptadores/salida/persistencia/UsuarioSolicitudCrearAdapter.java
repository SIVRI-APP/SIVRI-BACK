package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioSolicitudEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioSolicitudInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adaptador de salida que implementa el puerto de creación y actualización de solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitud y un Mapper para convertir entre modelos y entidades.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudCrearAdapter implements UsuarioSolicitudCrearREPO {

    /** Repositorio */
    private final UsuarioSolicitudRepository usuarioSolicitudRepository;

    /** Mapper */
    private final UsuarioSolicitudInfraMapper usuarioSolicitudInfraMapper;

    /**
     * @see UsuarioSolicitudCrearREPO#crearSolicitudUsuario(UsuarioSolicitud)
     */
    @Override
    public UsuarioSolicitud crearSolicitudUsuario(UsuarioSolicitud usuario) {
        return usuarioSolicitudInfraMapper.toModel(usuarioSolicitudRepository.save(usuarioSolicitudInfraMapper.toEntity(usuario)));
    }

    @Override
    public void cambiarEstado(Long solicitudId, EstadoSolicitudUsuario estado) {
        UsuarioSolicitudEntity solicitud = usuarioSolicitudRepository.findById(solicitudId).orElseThrow();
        solicitud.setEstado(estado);
        usuarioSolicitudRepository.save(solicitud);
    }

}
