package edu.unicauca.SivriBackendApp.core.academica.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.Programa;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.ProgramaObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.SemilleroProgramaCrearCU;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.out.SemilleroProgramaCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroObtenerCU;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SemilleroProgramaCrearService implements SemilleroProgramaCrearCU {
    private final SemilleroProgramaCrearREPO semilleroProgramaCrearREPO;
    private final SemilleroObtenerCU semilleroObtenerCU;
    private final ProgramaObtenerCU programaObtenerCU;

    public SemilleroProgramaCrearService(SemilleroProgramaCrearREPO semilleroProgramaCrearREPO, SemilleroObtenerCU semilleroObtenerCU, ProgramaObtenerCU programaObtenerCU) {
        this.semilleroProgramaCrearREPO = semilleroProgramaCrearREPO;
        this.semilleroObtenerCU = semilleroObtenerCU;
        this.programaObtenerCU = programaObtenerCU;
    }

    @Override
    public Respuesta<Boolean> crear(int semilleroId, int programaId) {
        semilleroObtenerCU.existePorId(semilleroId);
        Semillero semilleroObtenido=semilleroObtenerCU.obtenerSemilleroPorId(semilleroId).getData();
        programaObtenerCU.existePorId(programaId);
        Programa programaObtenido=programaObtenerCU.obtenerPorId(programaId).getData();

        SemilleroPrograma objSemilleroPrograma=new SemilleroPrograma();
        objSemilleroPrograma.setSemillero(semilleroObtenido);
        objSemilleroPrograma.setPrograma(programaObtenido);
        Boolean respuesta=semilleroProgramaCrearREPO.crear(objSemilleroPrograma);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Semillero Programa", "IdSemillero","IdPrograma", String.valueOf(semilleroId),String.valueOf(programaId)));
        }

        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Semillero Programa"), "", true).getRespuesta();
    }
}
