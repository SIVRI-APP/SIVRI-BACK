package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.port.in.ConvocatoriaCrearCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.port.in.TipoFinanciacionObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.port.out.ConvocatoriaCrearREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvocatoriaCrearService implements ConvocatoriaCrearCU {

    private final ConvocatoriaCrearREPO convocatoriaCrearREPO;
    private final TipoFinanciacionObtenerCU tipoFinanciacionObtenerCU;

    public ConvocatoriaCrearService(ConvocatoriaCrearREPO convocatoriaCrearREPO, TipoFinanciacionObtenerCU tipoFinanciacionObtenerCU) {
        this.convocatoriaCrearREPO = convocatoriaCrearREPO;
        this.tipoFinanciacionObtenerCU = tipoFinanciacionObtenerCU;
    }

    @Override
    public Respuesta<Boolean> crear(Convocatoria nuevosDatos) {

        tipoFinanciacionObtenerCU.existePorId(nuevosDatos.getTipoFinanciacion().getId());

        Boolean respuesta = convocatoriaCrearREPO.crear(nuevosDatos);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Convocatoria", "Id", String.valueOf(nuevosDatos.getId())));
        }

        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Convocatoria"), "", true).getRespuesta();
    }
}