package edu.unicauca.SivriBackendApp.core.academica.domain.service;


import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.Programa;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.ProgramaObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.out.ProgramaObtenerREPO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProgramaObtenerService implements ProgramaObtenerCU {
    private final ProgramaObtenerREPO programaObtenerREPO;

    public ProgramaObtenerService(ProgramaObtenerREPO programaObtenerREPO) {
        this.programaObtenerREPO = programaObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=programaObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Programa", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();

    }

    @Override
    public Respuesta<Programa> obtenerPorId(int id) {
        Optional<Programa> respuestaBd= programaObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro",List.of("Programa","Id",String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<Programa>> listarProgramasPorSemillero(int idSemillero) {
        List<Programa> respuestaBd =programaObtenerREPO.listarProgramasPorSemillero(idSemillero);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<Programa>> obtenerProgramas() {
        List<Programa> respuestaBd =programaObtenerREPO.obtenerProgramas();
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }
}
