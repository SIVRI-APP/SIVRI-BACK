package edu.unicauca.SivriBackendApp.core.usuario.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioCrearREPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioCrearService implements UsuarioCrearCU {

    private final UsuarioCrearREPO usuarioCrearREPO;
    private final UsuarioObtenerCU usuarioObtenerCU;

    @Override
    public Respuesta guardar(Usuario usuario) {

        if (usuarioObtenerCU.existsByCorreoAndTipoDocumentoAndNumeroDocumento(usuario.getCorreo(), usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento())){
            throw new ReglaDeNegocioException("bad.usuario.ya.existe", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento()));
        }

        //TODO 1 guardar en otra tabla
        usuarioCrearREPO.save(usuario);

        return new RespuestaHandler<>(200, "ok.usuario.solicitud.creacion", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento()), "",true).getRespuesta();
    }
}
