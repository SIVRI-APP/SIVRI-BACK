package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.CompromisoSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.CompromisoSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.CompromisoSemillero;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompromisoSemilleroObtenerService implements CompromisoSemilleroObtenerCU {
    private final CompromisoSemilleroObtenerREPO compromisoSemilleroObtenerREPO;

    public CompromisoSemilleroObtenerService(CompromisoSemilleroObtenerREPO compromisoSemilleroObtenerREPO) {
        this.compromisoSemilleroObtenerREPO = compromisoSemilleroObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=compromisoSemilleroObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Compromiso Semillero", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<CompromisoSemillero> obtenerPorId(int id) {
        Optional<CompromisoSemillero> respuestaBd=compromisoSemilleroObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Compromiso Semillero", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<CompromisoSemillero>> obtenerListadoCompromisos() {
        List<CompromisoSemillero> respuestaBd=compromisoSemilleroObtenerREPO.obtenerListadoCompromisos();
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }
}
