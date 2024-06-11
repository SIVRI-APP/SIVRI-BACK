package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioSolicitudObservacionCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * El servicio UsuarioSolicitudObservacionCrearService implementa la lógica para crear, editar, devolver con observaciones
 * y aprobar solicitudes de usuarios en el sistema, gestionando las operaciones a través de repositorios
 * y validaciones correspondientes.
 */
@Service
@RequiredArgsConstructor
public class UsuarioSolicitudObservacionCrearService implements UsuarioSolicitudObservacionCrearCU {


    /** Puertos de Salida */
    private final UsuarioSolicitudObservacionCrearREPO usuarioSolicitudObservacionCrearREPO;

    /**
     * @see UsuarioSolicitudObservacionCrearCU#resolverObservacion(Long)
     */
    @Override
    public Respuesta<Boolean> resolverObservacion(Long observacionId) {
        usuarioSolicitudObservacionCrearREPO.cambiarEstado(observacionId);
        return new RespuestaHandler<>(200, "ok.solicitud.observacion.resuelta", "", true).getRespuesta();
    }





}