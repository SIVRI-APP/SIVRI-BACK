package edu.unicauca.SivriBackendApp.core.grupo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoDisciplina;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.DisciplinaObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoDisciplinaCrearCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.GrupoDisciplinaCrearREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GrupoDisciplinaCrearService implements GrupoDisciplinaCrearCU {
    private final GrupoDisciplinaCrearREPO grupoDisciplinaCrearREPO;
    private final GrupoObtenerCU grupoObtenerCU;
    private final DisciplinaObtenerCU disciplinaObtenerCU;
    public GrupoDisciplinaCrearService(GrupoDisciplinaCrearREPO grupoDisciplinaCrearREPO, GrupoObtenerCU grupoObtenerCU, DisciplinaObtenerCU disciplinaObtenerCU) {
        this.grupoDisciplinaCrearREPO = grupoDisciplinaCrearREPO;
        this.grupoObtenerCU = grupoObtenerCU;
        this.disciplinaObtenerCU = disciplinaObtenerCU;
    }

    @Override
    public Respuesta<Boolean> crear(int grupoId, int disciplinaId) {
        grupoObtenerCU.existePorId(grupoId);
        Grupo grupo=grupoObtenerCU.obtenerGrupoPorId(grupoId).getData();
        disciplinaObtenerCU.existePorId(disciplinaId);
        Disciplina disciplina=disciplinaObtenerCU.obtenerPorId(disciplinaId).getData();
        GrupoDisciplina objGrupoDisciplina=new GrupoDisciplina();
        objGrupoDisciplina.setGrupo(grupo);
        objGrupoDisciplina.setDisciplina(disciplina);
        Boolean respuesta=grupoDisciplinaCrearREPO.crear(objGrupoDisciplina);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Grupo Disciplina", "IdGrupo","IdDisciplina", String.valueOf(grupoId),String.valueOf(disciplinaId)));
        }
        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Grupo Disciplina"), "", true).getRespuesta();
    }
}
