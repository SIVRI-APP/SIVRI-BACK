package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.PlanTrabajoObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.PlanTrabajoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ObtenerPlanTrabajoxanio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Component
public class PlanTrabajoObtenerService implements PlanTrabajoObtenerCU {
    private final PlanTrabajoObtenerREPO planTrabajoObtenerREPO;

    public PlanTrabajoObtenerService(PlanTrabajoObtenerREPO planTrabajoObtenerREPO) {
        this.planTrabajoObtenerREPO = planTrabajoObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=planTrabajoObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Plan Trabajo", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> existePorIdSemilleroyAnio(Integer idSemillero, Integer anio) {
        Boolean respuesta=false;
        Integer respuestaBd=planTrabajoObtenerREPO.existePorIdSemilleroyAnio(idSemillero,anio);
        if (respuestaBd == 1){
            respuesta= true;
            throw new ReglaDeNegocioException("bad.error.creacionSemillero.objeto",List.of("Plan de Trabajo","id semillero",String.valueOf(idSemillero),"año",String.valueOf(anio)," El Plan ya se encuentra creado"));
        }/*else {
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro.plan",List.of("Plan de Trabajo" ,"id semillero",String.valueOf(idSemillero),"año",String.valueOf(anio)));
        }*/
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","",false).getRespuesta();
    }

    @Override
    public Respuesta<PlanTrabajo> obtenerPorId(int id) {
        Optional<PlanTrabajo> respuestaBd= planTrabajoObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Plan Trabajo", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<PlanTrabajo>> obtenerPlanesPorIdSemillero(int idSemillero) {
        List<PlanTrabajo> respuestaBd= planTrabajoObtenerREPO.obtenerPlanesPorIdSemillero(idSemillero);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Page<List<ObtenerPlanTrabajoxanio>>> obtenerPlanTrabajoxAnio(int pageNo, int pageSize, Integer anio,Integer idSemillero, LocalDate fechaInicio, LocalDate fechaFin) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<List<ObtenerPlanTrabajoxanio>> respuestaBd= planTrabajoObtenerREPO.obtenerPlanTrabajoxAnio(pageable, anio,idSemillero, fechaInicio, fechaFin);
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<PlanTrabajo>> obtenerListadoPlanes() {
        List<PlanTrabajo> respuestaBd= planTrabajoObtenerREPO.obtenerListadoPlanes();
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }
}
