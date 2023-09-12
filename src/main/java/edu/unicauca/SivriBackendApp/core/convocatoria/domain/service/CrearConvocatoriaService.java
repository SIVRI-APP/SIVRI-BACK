package edu.unicauca.SivriBackendApp.core.convocatoria.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.CrearConvocatoriaCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out.CrearConvocatoriaREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrearConvocatoriaService implements CrearConvocatoriaCU {

    private final CrearConvocatoriaREPO crearConvocatoriaREPO;

    public CrearConvocatoriaService(CrearConvocatoriaREPO crearConvocatoriaREPO) {
        this.crearConvocatoriaREPO = crearConvocatoriaREPO;
    }

    @Override
    public Respuesta<Boolean> crear(Convocatoria nuevosDatos) {

        Boolean respuesta = crearConvocatoriaREPO.crear(nuevosDatos);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Convocatoria", "Id", String.valueOf(nuevosDatos.getId())));
        }

        return new RespuestaHandler<>(201, "Convocatoria creada Exitosamente", "", true).getRespuesta();
    }
}
