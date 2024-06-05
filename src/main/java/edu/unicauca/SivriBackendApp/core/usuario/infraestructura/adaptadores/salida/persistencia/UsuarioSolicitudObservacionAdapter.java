package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioSolicitudObservacionCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioSolicitudObservacionesEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioSolicitudObservacionesInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioSolicitudObservacionesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adaptador de salida que implementa el puerto de creación y actualización de solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitud y un Mapper para convertir entre modelos y entidades.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudObservacionAdapter implements UsuarioSolicitudObservacionCrearREPO {

    /** Repositorio */
    private final UsuarioSolicitudObservacionesRepository usuarioSolicitudObservacionesRepository;

    /** Mapper */
    private final UsuarioSolicitudObservacionesInfraMapper usuarioSolicitudObservacionesInfraMapper;


    /**
     * @see UsuarioSolicitudObservacionCrearREPO#crearObservacion(UsuarioSolicitudObservaciones)
     */
    @Override
    public void crearObservacion(UsuarioSolicitudObservaciones usuarioSolicitudObservaciones) {
        usuarioSolicitudObservacionesRepository.save(usuarioSolicitudObservacionesInfraMapper.toEntity(usuarioSolicitudObservaciones));
    }

    @Override
    public void cambiarEstado(Long observacionId) {
        UsuarioSolicitudObservacionesEntity observacion = usuarioSolicitudObservacionesRepository.findById(observacionId).orElseThrow();
        observacion.setResuelta(!observacion.getResuelta());
        usuarioSolicitudObservacionesRepository.save(observacion);
    }


}
