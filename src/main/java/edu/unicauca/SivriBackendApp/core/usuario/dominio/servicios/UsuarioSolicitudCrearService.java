package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificaciónDeUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObservaciónCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores.UsuarioSolicitudValidador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * El servicio UsuarioSolicitudCrearService implementa la lógica para crear, editar, devolver con observaciones
 * y aprobar solicitudes de usuarios en el sistema, gestionando las operaciones a través de repositorios
 * y validaciones correspondientes.
 */
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

    /**
     * Crea una solicitud de usuario en el sistema.
     *
     * @param usuario Información del usuario solicitante.
     * @return Respuesta que indica el éxito de la operación.
     * @throws ReglaDeNegocioException Si la solicitud ya existe en el sistema.
     */
    @Override
    public Respuesta<Boolean> crearSolicitudUsuario(UsuarioSolicitud usuario) {
        usuarioSolicitudValidador.validaciónSolicitudUsuarioNoExiste(usuario);

        usuario.setEstado(EstadoSolicitudUsuario.REVISION_VRI);

        usuarioSolicitudCrearREPO.crearUsuarioSolicitud(usuario);

        return new RespuestaHandler<>(200, "ok.usuario.solicitud.creación", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento(), usuario.getCorreo()), "", true).getRespuesta();
    }

    /**
     * Devuelve una solicitud de usuario con observaciones.
     *
     * @param solicitudUsuarioId Identificador de la solicitud de usuario.
     * @param observaciones      Observaciones asociadas a la solicitud.
     * @return Respuesta que indica el éxito de la operación.
     * @throws ReglaDeNegocioException Si la solicitud no está en estado de revisión.
     */
    @Override
    public Respuesta<Boolean> devolverSolicitudConObservaciones(long solicitudUsuarioId, String observaciones) {
        UsuarioSolicitud solicitudUsuario = usuarioSolicitudObtenerCU.obtenerSolicitudUsuario(solicitudUsuarioId).getData();

        if (!solicitudUsuario.getEstado().equals(EstadoSolicitudUsuario.REVISION_VRI)) {
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

        // TODO: Miguel enviar correo al usuario

        return new RespuestaHandler<>(200, "ok.solicitud.devuelta", "", true).getRespuesta();
    }

    /**
     * Edita una solicitud de usuario en el sistema.
     *
     * @param solicitudId Identificador de la solicitud de usuario.
     * @param usuario     Información actualizada del usuario solicitante.
     * @return Respuesta que indica el éxito de la operación.
     * @throws ReglaDeNegocioException Si no se puede editar la solicitud.
     */
    @Override
    public Respuesta<Boolean> editarSolicitudUsuario(long solicitudId, UsuarioSolicitud usuario) {
        UsuarioSolicitud solicitudUsuario = usuarioSolicitudObtenerCU.obtenerSolicitudUsuario(solicitudId).getData();

        if (!servicioDeIdentificaciónDeUsuario.esFuncionario() && solicitudUsuario.getEstado().equals(EstadoSolicitudUsuario.REVISION_VRI)) {
            throw new ReglaDeNegocioException("bad.no.se.puede.editar.la.solicitud");
        }

        if (!servicioDeIdentificaciónDeUsuario.esFuncionario()) {
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

        return new RespuestaHandler<>(200, "ok", "", true).getRespuesta();
    }

    /**
     * Aprueba una solicitud de usuario en el sistema.
     *
     * @param solicitudId Identificador de la solicitud de usuario.
     * @return Respuesta que indica el éxito de la operación.
     * @throws ReglaDeNegocioException Sí existen observaciones pendientes para la solicitud.
     */
    @Override
    public Respuesta<Boolean> aprobarSolicitudUsuario(long solicitudId) {
        UsuarioSolicitud solicitudUsuario = usuarioSolicitudObtenerCU.obtenerSolicitudUsuario(solicitudId).getData();

        if (usuarioSolicitudObservacionesObtenerCU.solicitudConObservacionesPendientes(solicitudId).getData() > 0) {
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

        // TODO: Miguel crear el rol en el grupo

        // Eliminar solicitud
        usuarioSolicitudEliminarREPO.eliminar(solicitudId);

        return new RespuestaHandler<>(200, "ok", "", true).getRespuesta();
    }
}