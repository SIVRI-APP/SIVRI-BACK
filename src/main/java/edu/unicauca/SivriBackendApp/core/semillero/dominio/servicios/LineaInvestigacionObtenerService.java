package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.LineaInvestigacionObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.LineaInvestigacionObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarLineasInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.LineaInvestigacionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LineaInvestigacionObtenerService implements LineaInvestigacionObtenerCU {
    private final LineaInvestigacionObtenerREPO lineaInvestigacionObtenerREPO;

    public LineaInvestigacionObtenerService(LineaInvestigacionObtenerREPO lineaInvestigacionObtenerREPO) {
        this.lineaInvestigacionObtenerREPO = lineaInvestigacionObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=lineaInvestigacionObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Linea Investigacion", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<LineaInvestigacion> obtenerPorId(int id) {
        Optional<LineaInvestigacion> respuestaBd= lineaInvestigacionObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Linea Investigacion", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<Page<List<ListarLineasInvestigacion>>> obtenerLineasInvestigacionPorSemilleroId(int pageNo, int pageSize, int idSemillero) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<List<ListarLineasInvestigacion>> respuestaBd= lineaInvestigacionObtenerREPO.obtenerLineasInvestigacionPorSemilleroId(pageable,idSemillero);
       /* if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }*/

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<LineaInvestigacion>> obtenertotListadoLineasInvestigacion(int idSemillero) {
        List<LineaInvestigacion> respuestaBd= lineaInvestigacionObtenerREPO.obtenertotListadoLineasInvestigacion(idSemillero);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<LineaInvestigacion>> obtenerListadoLineasInvestigacion() {
        List<LineaInvestigacion> respuestaBd= lineaInvestigacionObtenerREPO.obtenerListadoLineasInvestigacion();
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

}