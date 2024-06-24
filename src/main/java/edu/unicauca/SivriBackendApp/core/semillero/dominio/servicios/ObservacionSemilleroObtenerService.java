package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.ObservacionSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.ObservacionSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarObservacionesPorIdSemillero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ObservacionSemilleroObtenerService implements ObservacionSemilleroObtenerCU {

    private final ObservacionSemilleroObtenerREPO observacionSemilleroObtenerREPO;
    private final SemilleroObtenerCU semilleroObtenerCU;

    public ObservacionSemilleroObtenerService(ObservacionSemilleroObtenerREPO observacionSemilleroObtenerREPO, SemilleroObtenerCU semilleroObtenerCU) {
        this.observacionSemilleroObtenerREPO = observacionSemilleroObtenerREPO;
        this.semilleroObtenerCU = semilleroObtenerCU;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=observacionSemilleroObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Observacion Semillero", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<ObservacionSemillero> obtenerPorId(int id) {
        Optional<ObservacionSemillero> respuestaBd= observacionSemilleroObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Observacion Semillero", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<Page<List<ListarObservacionesPorIdSemillero>>> listarObservacionesPorIdSemillero(int pageNo, int pageSize, int semilleroId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        semilleroObtenerCU.existePorId(semilleroId);
        Page<List<ListarObservacionesPorIdSemillero>> respuestaBd= observacionSemilleroObtenerREPO.listarObservacionesPorIdSemillero(pageable,semilleroId);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.observacion.semillero");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa","Exitoso",respuestaBd).getRespuesta();
    }
}
