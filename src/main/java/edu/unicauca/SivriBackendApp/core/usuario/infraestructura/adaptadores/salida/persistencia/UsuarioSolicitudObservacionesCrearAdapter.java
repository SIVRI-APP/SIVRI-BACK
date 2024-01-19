package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificaciónDeUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObservaciónCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad.UsuarioSolicitudObservacionesEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioSolicitudObservacionesInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorio.UsuarioSolicitudObservacionesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adaptador de salida que implementa el puerto de creación de observaciones para solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitudObservaciones para acceder a la capa de persistencia.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudObservacionesCrearAdapter implements UsuarioSolicitudObservaciónCrearREPO {

    /**
     * Repositorio de UsuarioSolicitudObservaciones que proporciona el acceso a la capa de persistencia.
     */
    private final UsuarioSolicitudObservacionesRepository usuarioSolicitudObservacionesRepository;

    /**
     * Mapper de infraestructura para convertir entre modelos y entidades de UsuarioSolicitudObservaciones.
     */
    private final UsuarioSolicitudObservacionesInfraMapper usuarioSolicitudObservacionesInfraMapper;

    /**
     * Servicio de identificación de usuario que proporciona información sobre el funcionario actual.
     */
    private final ServicioDeIdentificaciónDeUsuario servicioDeIdentificaciónDeUsuario;

    /**
     * Crea una nueva observación para una solicitud de usuario.
     *
     * @param observación Observación a ser creada.
     * @return La observación creada como un modelo de UsuarioSolicitudObservaciones.
     */
    @Override
    public UsuarioSolicitudObservaciones crearUsuarioSolicitud(UsuarioSolicitudObservaciones observación) {
        UsuarioSolicitudObservacionesEntity mapeo = usuarioSolicitudObservacionesInfraMapper.toEntity(observación);
        mapeo.setFuncionario(servicioDeIdentificaciónDeUsuario.obtenerFuncionario());
        return usuarioSolicitudObservacionesInfraMapper.toModel(usuarioSolicitudObservacionesRepository.save(mapeo));
    }
}
