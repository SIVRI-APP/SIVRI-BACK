package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoDisciplinaEliminarCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoDisciplinaObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoDisciplinaEliminarREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GrupoDisciplinaEliminarService implements GrupoDisciplinaEliminarCU {
    private final GrupoDisciplinaEliminarREPO grupoDisciplinaEliminarREPO;
    private final GrupoDisciplinaObtenerCU grupoDisciplinaObtenerCU;

    public GrupoDisciplinaEliminarService(GrupoDisciplinaEliminarREPO grupoDisciplinaEliminarREPO, GrupoDisciplinaObtenerCU grupoDisciplinaObtenerCU) {
        this.grupoDisciplinaEliminarREPO = grupoDisciplinaEliminarREPO;
        this.grupoDisciplinaObtenerCU = grupoDisciplinaObtenerCU;
    }

    @Override
    public Respuesta<Boolean> eliminacionGrupoDisciplinaFisico(long id) {
        grupoDisciplinaObtenerCU.existePorId(id);
        Boolean respuesta=grupoDisciplinaEliminarREPO.eliminacionGrupoDisciplinaFisico(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.eliminacion.objeto", List.of("Grupo Disciplina", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "success.eliminacion.objeto", List.of("Grupo Disciplina"), "Eliminación Fisico", true).getRespuesta();
    }
}
