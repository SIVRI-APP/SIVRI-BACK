package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.SubAreaObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.SubAreaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;
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
