package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.email.dto.MetaData;
import edu.unicauca.SivriBackendApp.common.email.dto.SendRequest;
import edu.unicauca.SivriBackendApp.common.email.service.SendMessageService;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.RegistroCredencialPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeCredencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificaciónDeUsuario;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.validadores.CredencialValidador;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores.UsuarioValidador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioCrearService implements UsuarioCrearCU {

    private final UsuarioCrearREPO usuarioCrearREPO;

    private final UsuarioValidador usuarioValidador;

    private final ServicioDeCredencial servicioDeCredencial;

    private final SendMessageService sendMessageService;

    @Override
    public Respuesta<Boolean> crearUsuario(Usuario usuario) {
        // Validaciones
        usuarioValidador.validaciónCreaciónUsuario(usuario);

        // Se crea el Usuario
        Usuario nuevoUsuario = usuarioCrearREPO.crearUsuario(usuario);

        // Si es Docente o Administrativo se crean credenciales
        if (usuario.getTipoUsuario().equals(TipoUsuario.DOCENTE) || usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRATIVO)){
            servicioDeCredencial.registrarCredencial(RegistroCredencialPetición
                    .builder()
                            .usuarioId(nuevoUsuario.getId())
                            .email(nuevoUsuario.getCorreo())
                            .password(nuevoUsuario.getNumeroDocumento())
                    .build());
        }

        //Enviar Correo
        enviarCorreo(nuevoUsuario);

        return new RespuestaHandler<>(200, "ok", "",true).getRespuesta();
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
