package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObservacionesCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioSolicitudObservacionInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioSolicitudObservacionesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UsuarioSolicitudObservacionesCrearAdapter implements UsuarioSolicitudObservacionesCrearREPO {


    private final UsuarioSolicitudObservacionesRepository usuarioSolicitudObservacionesRepository;
    private final UsuarioSolicitudObservacionInfraMapper usuarioSolicitudObservacionInfraMapper;

    /**
     * Obtiene la cantidad de observaciones pendientes para una solicitud de usuario.
     *
     * @param observacion Identificador de la solicitud de usuario.
     * @return Cantidad de observaciones pendientes como un entero.
     */
    @Override
    public Boolean crearObservacionSolicitudUsuario(UsuarioSolicitudObservaciones observacion) {
        usuarioSolicitudObservacionesRepository.save(usuarioSolicitudObservacionInfraMapper.toEntity(observacion));
        return true;
    }

}
