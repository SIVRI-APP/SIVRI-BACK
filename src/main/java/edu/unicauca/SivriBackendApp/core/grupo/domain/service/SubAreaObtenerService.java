package edu.unicauca.SivriBackendApp.core.grupo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.SubAreaObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.SubAreaObtenerREPO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SubAreaObtenerService implements SubAreaObtenerCU {

    private final SubAreaObtenerREPO subAreaObtenerREPO;

    public SubAreaObtenerService(SubAreaObtenerREPO subAreaObtenerREPO) {
        this.subAreaObtenerREPO = subAreaObtenerREPO;
    }

    @Override
    public Respuesta<List<Disciplina>> obtenerDisciplinasPorIdSubArea(int idSubArea) {
        List<Disciplina> respuestaBd= subAreaObtenerREPO.obtenerDisciplinaPorIdSubArea(idSubArea);
        if (respuestaBd.isEmpty()) {
            throw new ReglaDeNegocioException("subaAreas.Disciplina.NoEncontrada");
        }
        //System.out.println("respuesta "+respuestaBd);
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd).getRespuesta();

    }
}
