package edu.unicauca.SivriBackendApp.core.convocatoria.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ObtenerConvocatoriaCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out.ObtenerConvocatoriaREPO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ObtenerConvocatoriaService implements ObtenerConvocatoriaCU {

    private final ObtenerConvocatoriaREPO obtenerConvocatoriaREPO;

    public ObtenerConvocatoriaService(ObtenerConvocatoriaREPO obtenerConvocatoriaREPO) {
        this.obtenerConvocatoriaREPO = obtenerConvocatoriaREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(long id) {
        Boolean respuesta = obtenerConvocatoriaREPO.existePorId(id);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("ID", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "Exitoso", "Exitoso",true).getRespuesta();
    }

    @Override
    public Respuesta<Convocatoria> obtenerPorId(long id) {
        Optional<Convocatoria> respuestaBd = obtenerConvocatoriaREPO.obtenerPorId(id);

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("ID", String.valueOf(id)));
        }
        System.out.println(respuestaBd.get());
        return new RespuestaHandler<>(200, "Exitoso", "Exitoso", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<Convocatoria>> obtenerListado() {
        List<Convocatoria> respuestaBd = obtenerConvocatoriaREPO.obtenerListado();

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "Exitoso", "Exitoso", respuestaBd).getRespuesta();
    }
}
