package edu.unicauca.SivriBackendApp.core.academica.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.SemilleroProgramaEliminarCU;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.SemilleroProgramaObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.out.SemilleroProgramaEliminarREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SemilleroProgramaEliminarService implements SemilleroProgramaEliminarCU {
    private final SemilleroProgramaEliminarREPO semilleroProgramaEliminarREPO;
    private final SemilleroProgramaObtenerCU semilleroProgramaObtenerCU;

    public SemilleroProgramaEliminarService(SemilleroProgramaEliminarREPO semilleroProgramaEliminarREPO, SemilleroProgramaObtenerCU semilleroProgramaObtenerCU) {
        this.semilleroProgramaEliminarREPO = semilleroProgramaEliminarREPO;
        this.semilleroProgramaObtenerCU = semilleroProgramaObtenerCU;
    }

    @Override
    public Respuesta<Boolean> eliminacionSemilleroProgramaFisico(long id) {
        semilleroProgramaObtenerCU.existePorId(id).getData();
        Boolean respuesta=semilleroProgramaEliminarREPO.eliminadoFisicoSemilleroPrograma(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.eliminacion.objeto", List.of("Semillero Programa", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "success.eliminacion.objeto", List.of("Semillero Programa"), "Eliminación Fisico", true).getRespuesta();
    }
}
