package edu.unicauca.SivriBackendApp.core.proyecto.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ObtenerProyectosCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.ObtenerProyectosREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ObtenerProyectoService implements ObtenerProyectosCU {

    @Autowired
    private ObtenerProyectosREPO obtenerProyectosREPO;

    @Override
    public Respuesta<Proyecto> obtenerProyectoPorId(int id) {
        Optional<Proyecto> respuestaBd = obtenerProyectosREPO.obtenerProyectoPorId(id);

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Convocatoria", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "Exitoso", "Exitoso", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<Proyecto>> obtenerProyectos() {
        List<Proyecto> respuestaBd = obtenerProyectosREPO.obtenerProyectos();

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "Exitoso", "Exitoso", respuestaBd).getRespuesta();
    }
}
