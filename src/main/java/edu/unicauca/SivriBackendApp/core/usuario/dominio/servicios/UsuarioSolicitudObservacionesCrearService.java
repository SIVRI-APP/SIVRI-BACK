package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificaciónDeUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObservacionesCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada.RechazarSolicitudDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


/**
 * El servicio UsuarioSolicitudObtenerService implementa la lógica de negocio para la obtención
 * y filtrado de solicitudes de usuario.
 */
@Service
@AllArgsConstructor
public class UsuarioSolicitudObservacionesCrearService implements UsuarioSolicitudObservacionesCrearCU {

    private final UsuarioSolicitudObservacionesCrearREPO usuarioSolicitudObservacionesCrearREPO;
    private final UsuarioSolicitudObtenerCU usuarioSolicitudObtenerCU;
    private final ServicioDeIdentificaciónDeUsuario servicioDeIdentificaciónDeUsuario;

    /**
     * Lista las solicitudes de usuario filtradas y paginadas.
     *
     * @param rechazarSolicitud Información de la nueva observacion
     */
    @Override
    public Respuesta<Boolean> crearObservacionSolicitudUsuario(RechazarSolicitudDTO rechazarSolicitud) {
        UsuarioSolicitud solicitudUsuario = usuarioSolicitudObtenerCU.obtenerSolicitudUsuario(rechazarSolicitud.getUsuarioSolicitudId()).getData();

        usuarioSolicitudObservacionesCrearREPO.crearObservacionSolicitudUsuario(
                UsuarioSolicitudObservaciones.builder()
                        .solicitudUsuario(solicitudUsuario)
                        .funcionario(servicioDeIdentificaciónDeUsuario.obtenerFuncionarioModel())
                        .observación(rechazarSolicitud.getObservacion())
                        .fechaObservación(LocalDate.now())
                        .resuelta(false)
                        .notificaciónDeVencimiento(false)
                        .build()
        );

        return new RespuestaHandler<>(200, "ok", "", true).getRespuesta();
    }
}

