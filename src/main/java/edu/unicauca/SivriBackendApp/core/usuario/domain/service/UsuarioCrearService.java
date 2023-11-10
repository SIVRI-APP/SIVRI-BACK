package edu.unicauca.SivriBackendApp.core.usuario.domain.service;

import edu.unicauca.SivriBackendApp.common.email.dto.MetaData;
import edu.unicauca.SivriBackendApp.common.email.dto.SendRequest;
import edu.unicauca.SivriBackendApp.common.email.service.SendMessageService;
import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.security.auth.UserRunTimeDetails;
import edu.unicauca.SivriBackendApp.common.security.credential.Credential;
import edu.unicauca.SivriBackendApp.common.security.credential.CredentialRepository;
import edu.unicauca.SivriBackendApp.common.security.credential.CredentialService;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuariosSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioCrearService implements UsuarioCrearCU {

    private final UsuarioCrearREPO usuarioCrearREPO;
    private final UsuariosSolicitudCrearREPO usuariosSolicitudCrearREPO;
    private final UsuarioObtenerCU usuarioObtenerCU;
    private final UserRunTimeDetails userRunTimeDetails;
    private final SendMessageService sendMessageService;
    private final CredentialService credentialService;

    @Override
    public Respuesta registrarUsuario(Usuario usuario) {

        if (usuarioObtenerCU.existsByTipoDocumentoAndNumeroDocumento(usuario.getTipoDocumento(), usuario.getNumeroDocumento()).getData()){
            throw new ReglaDeNegocioException("bad.usuario.ya.existe", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento()));
        }

        if (usuarioObtenerCU.existsByCorreo(usuario.getCorreo()).getData()){
            throw new ReglaDeNegocioException("bad.usuario.correo.ya.existe", List.of(usuario.getCorreo()));
        }

        if (userRunTimeDetails.getUserRunTimeRoles().contains("FUNCIONARIO:USUARIOS") || userRunTimeDetails.getUserRunTimeRoles().contains("FUNCIONARIO:SUPER_ADMIN")){
            //Creamos el Usuario
            Usuario nuevoUsuario = usuarioCrearREPO.registrarUsuario(usuario);

            //Creamos la credencial en estado pendiente
            credentialService.crearCredencial(nuevoUsuario);

            // Si el Usuario es Docente requiere credenciales
            if (usuario.getTipoUsuario().equals(TipoUsuario.DOCENTE) || usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRATIVO)){
                //Enviamos el correo para crear las Credenciales, ya que el usuario se ha creado directamente.
                return enviarCorreo(usuario);
            }

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

        return new RespuestaHandler<>(200, "ok.usuario.solicitud.creacion", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento()), "",true).getRespuesta();
    }

    private Respuesta enviarCorreo(Usuario usuario){
        List<MetaData> metaData = new ArrayList<>();
        metaData.add(MetaData.builder()
                .key("nombre")
                .value(usuario.getNombres())
                .build());
        metaData.add(MetaData.builder()
                .key("tipoUsuario")
                .value(usuario.getTipoUsuario().toString())
                .build());
        metaData.add(MetaData.builder()
                .key("grupoInvestigacion")
                .value("PENDIENTE YURANI")
                .build());
        metaData.add(MetaData.builder()
                .key("rolGrupo")
                .value("PENDIENTE YURANI")
                .build());

        return sendMessageService.sendMessage(SendRequest.builder()
                .to(usuario.getCorreo())
                .subject("Te damos la bienvenida a SIVRI")
                .template(1)
                .metaData(metaData)
                .build());
    }

}
