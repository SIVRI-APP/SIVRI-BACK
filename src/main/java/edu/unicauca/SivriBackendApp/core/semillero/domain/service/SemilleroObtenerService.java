package edu.unicauca.SivriBackendApp.core.semillero.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.SemilleroObtenerREPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SemilleroObtenerService implements SemilleroObtenerCU {
    private final SemilleroObtenerREPO semilleroObtenerREPO;

    public SemilleroObtenerService(SemilleroObtenerREPO semilleroObtenerREPO) {
        this.semilleroObtenerREPO = semilleroObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=semilleroObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Semillero", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<Semillero> obtenerSemilleroPorId(int id) {
        Optional<Semillero> respuesta=semilleroObtenerREPO.obtenerSemilleroPorId(id);
        if (respuesta.isEmpty()) {
            throw new ReglaDeNegocioException("el id " + id + " no existe.");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "Exitoso", respuesta.get()).getRespuesta();
    }
    @Override
    public Respuesta<List<Semillero>> obtenerSemillerosPorIdGrupo(int idGrupo) {
        List<Semillero> respuesta=semilleroObtenerREPO.obtenerSemillerosPorIdGrupo(idGrupo);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();
    }

    /*@Override
    public Respuesta<List<Semillero>> obtenerSemillerosPorIdMentor(String idMentor) {
        List<Semillero> respuesta=semilleroObtenerREPO.obtenerSemillerosPorIdMentor(idMentor);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros.mentor");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();

    }*/

    @Override
    public Respuesta<List<Semillero>> obtenerSemilleros() {
        List<Semillero> respuesta=semilleroObtenerREPO.obtenerSemilleros();
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();
    }

    @Override
    public Respuesta<Page<Semillero>> obtenerSemillerosPaginado(int pageNo, int pageSize) {
        PageRequest pageRequest=PageRequest.of(pageNo, pageSize);
        Page<Semillero> respuestaBd= semilleroObtenerREPO.obtenerListadoSemilleroPaginado(pageRequest);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

}
