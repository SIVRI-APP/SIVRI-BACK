package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores.UsuarioSolicitudValidador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioSolicitudCrearService implements UsuarioSolicitudCrearCU {

    private final UsuarioSolicitudCrearREPO usuarioSolicitudCrearREPO;
    private final UsuarioSolicitudValidador usuarioSolicitudValidador;

    @Override
    public Respuesta<Boolean> crearSolicitudUsuario(UsuarioSolicitud usuario) {

        usuarioSolicitudValidador.validaciónSolicitudUsuarioNoExiste(usuario);

        usuario.setEstado(EstadoSolicitudUsuario.REVISION_VRI);

        usuarioSolicitudCrearREPO.crearUsuarioSolicitud(usuario);

        return new RespuestaHandler<>(200, "ok.usuario.solicitud.creación", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento(), usuario.getCorreo()), "",true).getRespuesta();
    }



}
