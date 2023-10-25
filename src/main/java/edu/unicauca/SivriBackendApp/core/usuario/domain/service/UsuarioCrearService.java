package edu.unicauca.SivriBackendApp.core.usuario.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.EstadoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioObtenerREPO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioCrearService implements UsuarioCrearCU {

    private final UsuarioCrearREPO usuarioCrearREPO;
    private final UsuarioObtenerREPO usuarioObtenerREPO;

    public UsuarioCrearService(UsuarioCrearREPO usuarioCrearREPO, UsuarioObtenerREPO usuarioObtenerREPO) {
        this.usuarioCrearREPO = usuarioCrearREPO;
        this.usuarioObtenerREPO = usuarioObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> solicitudCreacionDeUsuario(Usuario nuevoUsuario) {

        if (usuarioObtenerREPO.validarExistencia(nuevoUsuario.getTipoDocumento(), nuevoUsuario.getNumeroDocumento())){
            throw new ReglaDeNegocioException("bad.usuario.ya.existe", List.of(nuevoUsuario.getTipoDocumento().toString(), nuevoUsuario.getNumeroDocumento()));
        }

        if (usuarioObtenerREPO.validarExistenciaCorreo(nuevoUsuario.getCorreo())){
            throw new ReglaDeNegocioException("bad.usuario.correo.ya.existe", List.of(nuevoUsuario.getCorreo()));
        }

        nuevoUsuario.setEstado(EstadoUsuario.REVISION_VRI);
        usuarioCrearREPO.solicitudCreacionDeUsuario(nuevoUsuario);

        return new RespuestaHandler<>(200, "sucess.usuario.solicitud.creacion", List.of(nuevoUsuario.getTipoDocumento().toString(), nuevoUsuario.getNumeroDocumento()), "", true).getRespuesta();
    }
}
