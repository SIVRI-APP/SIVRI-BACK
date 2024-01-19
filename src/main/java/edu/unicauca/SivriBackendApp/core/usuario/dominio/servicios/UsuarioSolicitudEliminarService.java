package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudEliminarCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudEliminadoProgramadoProyección;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * El servicio UsuarioSolicitudEliminarService implementa la lógica de negocio
 * para la eliminación programada de solicitudes de usuarios.
 */
@Service
@AllArgsConstructor
public class UsuarioSolicitudEliminarService implements UsuarioSolicitudEliminarCU {

    private final UsuarioSolicitudEliminarREPO usuarioSolicitudEliminarREPO;

    /**
     * Realiza la eliminación programada de solicitudes de usuarios.
     *
     * @return Respuesta que indica el éxito de la operación.
     */
    @Override
    public Respuesta<Boolean> eliminadoProgramado() {
        // Obtener la lista de solicitudes eliminadas programadamente
        List<UsuarioSolicitudEliminadoProgramadoProyección> respuestaBd = usuarioSolicitudEliminarREPO.eliminadoProgramado();

        // Imprimir información de las solicitudes eliminadas programadamente
        respuestaBd.forEach(
                (x) -> System.out.println(x.getId() + " " + x.getFechaObservación())
        );

        return new RespuestaHandler<>(200, "ok", "", true).getRespuesta();
    }
}
