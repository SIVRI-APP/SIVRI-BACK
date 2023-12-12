package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudEliminarCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudEliminadoProgramadoProyección;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UsuarioSolicitudEliminarService implements UsuarioSolicitudEliminarCU {

    private final UsuarioSolicitudEliminarREPO usuarioSolicitudEliminarREPO;
    @Override
    public Respuesta<Boolean> eliminadoProgramado() {
        List<UsuarioSolicitudEliminadoProgramadoProyección> respuestaBd = usuarioSolicitudEliminarREPO.eliminadoProgramado();

        respuestaBd.stream().forEach(
                (x) -> System.out.println(x.getId() + " " + x.getFechaObservación())
        );



        return new RespuestaHandler<>(200, "ok", "",true).getRespuesta();
    }
}
