package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.port.in.TipoFinanciacionObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.port.out.TipoFinanciacionObtenerREPO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TipoFinanciacionObtenerService implements TipoFinanciacionObtenerCU {

    private final TipoFinanciacionObtenerREPO tipoFinanciacionObtenerREPO;

    public TipoFinanciacionObtenerService(TipoFinanciacionObtenerREPO tipoFinanciacionObtenerREPO) {
        this.tipoFinanciacionObtenerREPO = tipoFinanciacionObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(long id) {
        Boolean respuesta = tipoFinanciacionObtenerREPO.existePorId(id);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Tipo Financiación", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<TipoFinanciacion> obtenerPorId(long id) {
        Optional<TipoFinanciacion> respuestaBd = tipoFinanciacionObtenerREPO.obtenerPorId(id);

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Convocatoria", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<TipoFinanciacion>> obtenerListado() {
        List<TipoFinanciacion> respuestaBd = tipoFinanciacionObtenerREPO.obtenerListado();

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }
}
