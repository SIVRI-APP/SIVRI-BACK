package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificaciónDeUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudObservaciónCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioSolicitudObservacionesEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.mapper.UsuarioSolicitudObservacionesInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioSolicitudObservacionesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioSolicitudObservacionesCrearAdapter implements UsuarioSolicitudObservaciónCrearREPO {

    private final UsuarioSolicitudObservacionesRepository usuarioSolicitudObservacionesRepository;
    private final UsuarioSolicitudObservacionesInfraMapper usuarioSolicitudObservacionesInfraMapper;

    private final ServicioDeIdentificaciónDeUsuario servicioDeIdentificaciónDeUsuario;

    @Override
    public UsuarioSolicitudObservaciones crearUsuarioSolicitud(UsuarioSolicitudObservaciones observación) {

        UsuarioSolicitudObservacionesEntity mapeo = usuarioSolicitudObservacionesInfraMapper.toEntity(observación);
        mapeo.setFuncionario(servicioDeIdentificaciónDeUsuario.obtenerFuncionario());

        return usuarioSolicitudObservacionesInfraMapper.toModel(usuarioSolicitudObservacionesRepository.save(mapeo));
    }

}
