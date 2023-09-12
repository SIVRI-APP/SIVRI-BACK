package edu.unicauca.SivriBackendApp.core.convocatoria.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out.ConvocatoriaObtenerREPO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConvocatoriaObtenerService implements ConvocatoriaObtenerCU {

    private final ConvocatoriaObtenerREPO convocatoriaObtenerREPO;

    public ConvocatoriaObtenerService(ConvocatoriaObtenerREPO convocatoriaObtenerREPO) {
        this.convocatoriaObtenerREPO = convocatoriaObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(long id) {
        Boolean respuesta = convocatoriaObtenerREPO.existePorId(id);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Convocatoria", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "Exitoso", "Exitoso",true).getRespuesta();
    }

    @Override
    public Respuesta<Convocatoria> obtenerPorId(long id) {
        Optional<Convocatoria> respuestaBd = convocatoriaObtenerREPO.obtenerPorId(id);

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Convocatoria", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "Exitoso", "Exitoso", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<Convocatoria>> obtenerListado() {
        List<Convocatoria> respuestaBd = convocatoriaObtenerREPO.obtenerListado();

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "Exitoso", "Exitoso", respuestaBd).getRespuesta();
    }
}
