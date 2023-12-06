package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.email.dto.MetaData;
import edu.unicauca.SivriBackendApp.common.email.dto.SendRequest;
import edu.unicauca.SivriBackendApp.common.email.service.SendMessageService;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeCredencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificaciónDeUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudCrearREPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioCrearService implements UsuarioCrearCU {

    private final UsuarioCrearREPO usuarioCrearREPO;
    private final UsuarioObtenerCU usuarioObtenerCU;
    private final UsuarioSolicitudCrearREPO usuarioSolicitudCrearREPO;
    private final ServicioDeIdentificaciónDeUsuario servicioDeIdentificaciónDeUsuario;
    private final SendMessageService sendMessageService;
    private final ServicioDeCredencial servicioDeCredencial;

//    @Override
//    public Respuesta<Boolean> crearUsuario(Usuario usuario) {
//
//        if (usuarioObtenerCU.existePorTipoDocumentoNumeroDocumento(usuario.getTipoDocumento(), usuario.getNumeroDocumento()).getData()){
//            throw new ReglaDeNegocioException("bad.usuario.ya.existe", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento()));
//        }
//
//        if (usuarioObtenerCU.existePorCorreo(usuario.getCorreo()).getData()){
//            throw new ReglaDeNegocioException("bad.usuario.correo.ya.existe", List.of(usuario.getCorreo()));
//        }
//
//        if (servicioDeIdentificaciónDeUsuario.obtenerRoles().contains("FUNCIONARIO:USUARIOS") || servicioDeIdentificaciónDeUsuario.obtenerRoles().contains("FUNCIONARIO:SUPER_ADMIN")){
//            //Creamos el Usuario
//            Usuario nuevoUsuario = usuarioCrearREPO.crearUsuario(usuario);
//
//            //Creamos la credencial en estado pendiente
////            servicioDeCredencial.registrarCredencial(nuevoUsuario);
//
//            // Si el Usuario es Docente requiere credenciales
//            if (usuario.getTipoUsuario().equals(TipoUsuario.DOCENTE) || usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRATIVO)){
//                //Enviamos el correo para crear las Credenciales, ya que el usuario se ha creado directamente.
//                return enviarCorreo(usuario);
//            }
//
//        }else{
//            //TODO guardar la facultad, departamento o programa en caso del tipo de usuario
//            UsuarioSolicitud usuarioSolicitud = UsuarioSolicitud.builder()
//                    .correo(usuario.getCorreo())
//                    .tipoDocumento(usuario.getTipoDocumento())
//                    .numeroDocumento(usuario.getNumeroDocumento())
//                    .sexo(usuario.getSexo())
//                    .tipoUsuario(usuario.getTipoUsuario())
//                    .nombres(usuario.getNombres())
//                    .apellidos(usuario.getApellidos())
//                    .telefono(usuario.getTelefono())
//                    .cvLac(usuario.getCvLac())
//                    .estado(EstadoSolicitudUsuario.REVISION_VRI)
//                    .build();
//            usuarioSolicitudCrearREPO.crearUsuarioSolicitud(usuarioSolicitud);
//
//            return new RespuestaHandler<>(200, "ok.usuario.solicitud.creacion", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento()), "",true).getRespuesta();
//        }
//
//        return new RespuestaHandler<>(200, "ok.usuario.solicitud.creacion", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento()), "",true).getRespuesta();
//    }

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
