package edu.unicauca.SivriBackendApp.core.usuario.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.security.auth.UserRunTimeDetails;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuariosSolicitudCrearREPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioCrearService implements UsuarioCrearCU {

    private final UsuarioCrearREPO usuarioCrearREPO;
    private final UsuariosSolicitudCrearREPO usuariosSolicitudCrearREPO;
    private final UsuarioObtenerCU usuarioObtenerCU;
    private final UserRunTimeDetails userRunTimeDetails;

    @Override
    public Respuesta guardar(Usuario usuario) {

        if (usuarioObtenerCU.existsByTipoDocumentoAndNumeroDocumento(usuario.getTipoDocumento(), usuario.getNumeroDocumento()).getData()){
            throw new ReglaDeNegocioException("bad.usuario.ya.existe", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento()));
        }

        if (usuarioObtenerCU.existsByCorreo(usuario.getCorreo()).getData()){
            throw new ReglaDeNegocioException("bad.usuario.correo.ya.existe", List.of(usuario.getCorreo()));
        }

        if (userRunTimeDetails.getUserRunTimeRoles().contains("FUNCIONARIO:USUARIOS") || userRunTimeDetails.getUserRunTimeRoles().contains("FUNCIONARIO:SUPER_ADMIN")){
            usuarioCrearREPO.save(usuario);
            // TODO ejecutar HE01 HU03
            return null;
        }else{
            //TODO guardar la facultad, departamento o programa en caso del tipo de usuario
            UsuarioSolicitud usuarioSolicitud = UsuarioSolicitud.builder()
                    .correo(usuario.getCorreo())
                    .tipoDocumento(usuario.getTipoDocumento())
                    .numeroDocumento(usuario.getNumeroDocumento())
                    .sexo(usuario.getSexo())
                    .tipoUsuario(usuario.getTipoUsuario())
                    .nombres(usuario.getNombres())
                    .apellidos(usuario.getApellidos())
                    .telefono(usuario.getTelefono())
                    .cvLac(usuario.getCvLac())
                    .estado(EstadoSolicitudUsuario.REVISION_VRI)
                    .build();
            usuariosSolicitudCrearREPO.save(usuarioSolicitud);

            return new RespuestaHandler<>(200, "ok.usuario.solicitud.creacion", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento()), "",true).getRespuesta();
        }

    }
}
