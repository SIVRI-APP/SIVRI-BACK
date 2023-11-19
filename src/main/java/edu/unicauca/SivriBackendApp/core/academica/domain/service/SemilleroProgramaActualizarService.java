package edu.unicauca.SivriBackendApp.core.academica.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.Programa;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.ProgramaObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.SemilleroProgramaActualizarCU;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.SemilleroProgramaObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.out.SemilleroProgramaActualizarREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SemilleroProgramaActualizarService implements SemilleroProgramaActualizarCU {
    private final SemilleroProgramaActualizarREPO semilleroProgramaActualizarREPO;
    private final SemilleroProgramaObtenerCU semilleroProgramaObtenerCU;
    private final ProgramaObtenerCU programaObtenerCU;

    public SemilleroProgramaActualizarService(SemilleroProgramaActualizarREPO semilleroProgramaActualizarREPO, SemilleroProgramaObtenerCU semilleroProgramaObtenerCU, ProgramaObtenerCU programaObtenerCU) {
        this.semilleroProgramaActualizarREPO = semilleroProgramaActualizarREPO;
        this.semilleroProgramaObtenerCU = semilleroProgramaObtenerCU;
        this.programaObtenerCU = programaObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizar(long idSemilleroPrograma,int programaId) {
        SemilleroPrograma objSemilleroPrograma=semilleroProgramaObtenerCU.obtenerPorId(idSemilleroPrograma).getData();
        programaObtenerCU.existePorId(programaId);
        Programa programa=programaObtenerCU.obtenerPorId(programaId).getData();
        objSemilleroPrograma.setPrograma(programa);
        boolean respuesta=semilleroProgramaActualizarREPO.actualizar(objSemilleroPrograma);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Semillero Programa", "Id", String.valueOf(programaId)));
        }

        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Semillero Programa"), "", true).getRespuesta();
    }
}
