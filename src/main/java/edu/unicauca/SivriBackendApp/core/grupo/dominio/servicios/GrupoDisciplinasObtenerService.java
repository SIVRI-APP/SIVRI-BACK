package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoDisciplinaObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoDisciplinaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarDisciplinasPorGrupoId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GrupoDisciplinasObtenerService implements GrupoDisciplinaObtenerCU {
    private final GrupoDisciplinaObtenerREPO grupoDisciplinaObtenerREPO;
    private final GrupoObtenerCU grupoObtenerCU;

    public GrupoDisciplinasObtenerService(GrupoDisciplinaObtenerREPO grupoDisciplinaObtenerREPO, GrupoObtenerCU grupoObtenerCU) {
        this.grupoDisciplinaObtenerREPO = grupoDisciplinaObtenerREPO;
        this.grupoObtenerCU = grupoObtenerCU;

    }

    @Override
    public Respuesta<Boolean> existePorId(long id) {
        Boolean respuesta=grupoDisciplinaObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Grupo Disciplina", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();

    }

    @Override
    public Respuesta<GrupoDisciplina> obtenerPorId(long id) {
        Optional<GrupoDisciplina> respuestaBd =grupoDisciplinaObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Grupo Disciplina", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<GrupoDisciplina>> obtenerListadoDisciplinasPorGrupoId(int idGrupo) {
        grupoObtenerCU.existePorId(idGrupo);
        List<GrupoDisciplina> respuestaBd=grupoDisciplinaObtenerREPO.obtenerListadoDisciplinasPorGrupoId(idGrupo);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<ListarDisciplinasPorGrupoId>> obtenerDisciplinasxGrupoId(int idGrupo) {
        List<ListarDisciplinasPorGrupoId> respuestaBd=grupoDisciplinaObtenerREPO.obtenerDisciplinasxGrupoId(idGrupo);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro",List.of(" de disciplinas para el grupo ","Id",String.valueOf(idGrupo)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",respuestaBd).getRespuesta();
    }
}