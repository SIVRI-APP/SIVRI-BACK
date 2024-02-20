package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.LineaInvestigacionCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.LineaInvestigacionCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LineaInvestigacionCrearService implements LineaInvestigacionCrearCU {
    private final LineaInvestigacionCrearREPO lineaInvestigacionCrearREPO;

    public LineaInvestigacionCrearService(LineaInvestigacionCrearREPO lineaInvestigacionCrearREPO) {
        this.lineaInvestigacionCrearREPO = lineaInvestigacionCrearREPO;
    }

    @Override
    public Respuesta<Boolean> crear(int idSemillero, LineaInvestigacion nuevaLinea) {
        System.out.println("datosdelservice idsemillero "+idSemillero+" nuevalinea "+nuevaLinea);
        nuevaLinea.setSemilleroId(idSemillero);
        System.out.println("nuevaLinea "+nuevaLinea);
        Boolean respuesta= lineaInvestigacionCrearREPO.crear(nuevaLinea);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Linea Investigacion", "Id", String.valueOf(nuevaLinea.getId())));
        }
        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Linea Investigacion"), "", true).getRespuesta();
    }
}
