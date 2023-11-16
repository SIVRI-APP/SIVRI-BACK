package edu.unicauca.SivriBackendApp.core.academica.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.SemilleroProgramaObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.out.SemilleroProgramaObtenerREPO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SemilleroProgramaObtenerService implements SemilleroProgramaObtenerCU {
    private final SemilleroProgramaObtenerREPO semilleroProgramaObtenerREPO;

    public SemilleroProgramaObtenerService(SemilleroProgramaObtenerREPO semilleroProgramaObtenerREPO) {
        this.semilleroProgramaObtenerREPO = semilleroProgramaObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(long id) {
        Boolean respuesta=semilleroProgramaObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Semillero Programa", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<SemilleroPrograma> obtenerPorId(long id) {
        Optional<SemilleroPrograma> respuestaBd =semilleroProgramaObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Semillero Programa", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<SemilleroPrograma>> obtenerListadoProgramasPorSemilleroId(int idSemillero) {
        List<SemilleroPrograma> respuestaBd=semilleroProgramaObtenerREPO.obtenerListadoProgramasPorSemilleroId(idSemillero);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

}
