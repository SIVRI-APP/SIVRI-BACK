package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificaciónDeUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudObservacionesObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudObservaciónCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores.UsuarioSolicitudValidador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioSolicitudCrearService implements UsuarioSolicitudCrearCU {

    private final UsuarioCrearService usuarioCrearService;

    private final UsuarioSolicitudObtenerCU usuarioSolicitudObtenerCU;
    private final UsuarioSolicitudCrearREPO usuarioSolicitudCrearREPO;
    private final UsuarioSolicitudEliminarREPO usuarioSolicitudEliminarREPO;
    private final UsuarioSolicitudValidador usuarioSolicitudValidador;

    private final UsuarioSolicitudObservaciónCrearREPO usuarioSolicitudObservaciónCrearREPO;
    private final UsuarioSolicitudObservacionesObtenerCU usuarioSolicitudObservacionesObtenerCU;

    private final ServicioDeIdentificaciónDeUsuario servicioDeIdentificaciónDeUsuario;

    @Override
    public Respuesta<Boolean> crearSolicitudUsuario(UsuarioSolicitud usuario) {

        usuarioSolicitudValidador.validaciónSolicitudUsuarioNoExiste(usuario);

        usuario.setEstado(EstadoSolicitudUsuario.REVISION_VRI);

        usuarioSolicitudCrearREPO.crearUsuarioSolicitud(usuario);

        return new RespuestaHandler<>(200, "ok.usuario.solicitud.creación", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento(), usuario.getCorreo()), "",true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> devolverSolicitudConObservaciones(long solicitudUsuarioId, String observaciones) {
        UsuarioSolicitud solicitudUsuario = usuarioSolicitudObtenerCU.obtenerSolicitudUsuario(solicitudUsuarioId).getData();

        if (!solicitudUsuario.getEstado().equals(EstadoSolicitudUsuario.REVISION_VRI)){
            throw new ReglaDeNegocioException("bad.la.solicitud.no.esta.en.revisión");
        }

        solicitudUsuario.setEstado(EstadoSolicitudUsuario.FORMULADO_OBSERVACIONES);
        usuarioSolicitudCrearREPO.actualizarUsuarioSolicitud(solicitudUsuario);

        UsuarioSolicitudObservaciones observación = UsuarioSolicitudObservaciones.builder()
                        .solicitudUsuario(solicitudUsuario)
                        .observación(observaciones)
                        .fechaObservación(LocalDate.now())
                        .resuelta(false)
                        .build();

        usuarioSolicitudObservaciónCrearREPO.crearUsuarioSolicitud(observación);

        // TODO Miguel enviar correo al usuario

        return new RespuestaHandler<>(200, "ok.solicitud.devuelta", "",true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> editarSolicitudUsuario(long solicitudId, UsuarioSolicitud usuario) {
        UsuarioSolicitud solicitudUsuario = usuarioSolicitudObtenerCU.obtenerSolicitudUsuario(solicitudId).getData();

        if (!servicioDeIdentificaciónDeUsuario.esFuncionario() && solicitudUsuario.getEstado().equals(EstadoSolicitudUsuario.REVISION_VRI)){
            throw new ReglaDeNegocioException("bad.no.se.puede.editar.la.solicitud");
        }

        if(!servicioDeIdentificaciónDeUsuario.esFuncionario()){
            servicioDeIdentificaciónDeUsuario.perteneceAlGrupo(usuario.getGrupoId());
        }

        solicitudUsuario.setEstado(EstadoSolicitudUsuario.REVISION_VRI);
        solicitudUsuario.setCorreo(usuario.getCorreo());
        solicitudUsuario.setTipoDocumento(usuario.getTipoDocumento());
        solicitudUsuario.setNumeroDocumento(usuario.getNumeroDocumento());
        solicitudUsuario.setSexo(usuario.getSexo());
        solicitudUsuario.setTipoUsuario(usuario.getTipoUsuario());
        solicitudUsuario.setNombres(usuario.getNombres());
        solicitudUsuario.setApellidos(usuario.getApellidos());
        solicitudUsuario.setTelefono(usuario.getTelefono());
        solicitudUsuario.setCvLac(usuario.getCvLac());
        solicitudUsuario.setFacultadId(usuario.getFacultadId());
        solicitudUsuario.setDepartamentoId(usuario.getDepartamentoId());
        solicitudUsuario.setProgramaId(usuario.getProgramaId());
        solicitudUsuario.setGrupoId(usuario.getGrupoId());
        solicitudUsuario.setRolGrupoId(usuario.getRolGrupoId());
        solicitudUsuario.setNota(usuario.getNota());

        usuarioSolicitudCrearREPO.actualizarUsuarioSolicitud(solicitudUsuario);

        return new RespuestaHandler<>(200, "ok", "",true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> aprobarSolicitudUsuario(long solicitudId) {
        UsuarioSolicitud solicitudUsuario = usuarioSolicitudObtenerCU.obtenerSolicitudUsuario(solicitudId).getData();

        if (usuarioSolicitudObservacionesObtenerCU.solicitudConObservacionesPendientes(solicitudId).getData() > 0){
            throw new ReglaDeNegocioException("bad.no.se.puede.aprobar.solicitud.observaciones.pendientes");
        }

        // Crear usuario
        usuarioCrearService.crearUsuario(Usuario
                .builder()
                        .correo(solicitudUsuario.getCorreo())
                        .tipoDocumento(solicitudUsuario.getTipoDocumento())
                        .numeroDocumento(solicitudUsuario.getNumeroDocumento())
                        .sexo(solicitudUsuario.getSexo())
                        .tipoUsuario(solicitudUsuario.getTipoUsuario())
                        .nombres(solicitudUsuario.getNombres())
                        .apellidos(solicitudUsuario.getApellidos())
                        .telefono(solicitudUsuario.getTelefono())
                        .cvLac(solicitudUsuario.getCvLac())
                        .facultadId(solicitudUsuario.getFacultadId())
                        .departamentoId(solicitudUsuario.getDepartamentoId())
                        .programaId(solicitudUsuario.getProgramaId())
                .build()
        );

        // TODO Miguel crear el rol en el grupo

        // Eliminar solicitud
        usuarioSolicitudEliminarREPO.eliminar(solicitudId);

        return new RespuestaHandler<>(200, "ok", "",true).getRespuesta();
    }


}
