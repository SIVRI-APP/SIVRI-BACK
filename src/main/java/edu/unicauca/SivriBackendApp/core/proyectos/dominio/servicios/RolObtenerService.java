package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.RolObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.RolObtenerREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RolObtenerService implements RolObtenerCU {

    private final RolObtenerREPO rolObtenerREPO;

    @Override
    public Respuesta<RolProyecto> obtenerRolPorId(int rolId) {

        Optional<RolProyecto> rol = rolObtenerREPO.obtenerProyectoPorId(rolId);

        if (rol.isEmpty()){
            throw new ReglaDeNegocioException("bad.rolNoExiste", List.of(String.valueOf(rolId)));
        }

        return new RespuestaHandler<>(200, "ok", "", rol.get()).getRespuesta();
    }
}
