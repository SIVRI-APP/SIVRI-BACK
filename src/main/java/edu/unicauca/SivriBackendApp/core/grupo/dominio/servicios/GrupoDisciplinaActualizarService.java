package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.DisciplinaObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoDisciplinaActualizarCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoDisciplinaObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoDisciplinaActualizarREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GrupoDisciplinaActualizarService implements GrupoDisciplinaActualizarCU {
    private final GrupoDisciplinaActualizarREPO grupoDisciplinaActulizarREPO;
    private final GrupoDisciplinaObtenerCU grupoDisciplinaObtenerCU;
    private final DisciplinaObtenerCU disciplinaObtenerCU;

    public GrupoDisciplinaActualizarService(GrupoDisciplinaActualizarREPO grupoDisciplinaActulizarREPO, GrupoDisciplinaObtenerCU grupoDisciplinaObtenerCU, DisciplinaObtenerCU disciplinaObtenerCU) {
        this.grupoDisciplinaActulizarREPO = grupoDisciplinaActulizarREPO;
        this.grupoDisciplinaObtenerCU = grupoDisciplinaObtenerCU;
        this.disciplinaObtenerCU = disciplinaObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizar(long idGrupoDisciplina, int disciplinaId) {
        GrupoDisciplina objGrupoDisciplina=grupoDisciplinaObtenerCU.obtenerPorId(idGrupoDisciplina).getData();
        disciplinaObtenerCU.existePorId(disciplinaId);
        Disciplina disciplina=disciplinaObtenerCU.obtenerPorId(disciplinaId).getData();
        objGrupoDisciplina.setDisciplina(disciplina);
        boolean respuesta= grupoDisciplinaActulizarREPO.actualizar(objGrupoDisciplina);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Grupo Disciplina", "Id", String.valueOf(disciplinaId)));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Grupo Disciplina"), "", true).getRespuesta();
    }
}
