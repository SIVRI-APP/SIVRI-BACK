package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.DisciplinaObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.DisciplinaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DisciplinaObtenerService implements DisciplinaObtenerCU {
    private final DisciplinaObtenerREPO disciplinaObtenerREPO;

    public DisciplinaObtenerService(DisciplinaObtenerREPO disciplinaObtenerREPO) {
        this.disciplinaObtenerREPO = disciplinaObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=disciplinaObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Disciplina", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<Disciplina> obtenerPorId(int id) {
        Optional<Disciplina> respuestaBd=disciplinaObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro",List.of("Disciplina","Id",String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }
}
