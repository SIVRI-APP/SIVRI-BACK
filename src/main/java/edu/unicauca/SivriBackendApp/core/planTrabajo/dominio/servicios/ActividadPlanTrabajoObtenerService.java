package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.ActividadPlanTrabajoObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.ActividadPlanTrabajoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ListarActividadesConFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Component
public class ActividadPlanTrabajoObtenerService implements ActividadPlanTrabajoObtenerCU {
    private final ActividadPlanTrabajoObtenerREPO actividadPlanTrabajoObtenerREPO;

    public ActividadPlanTrabajoObtenerService(ActividadPlanTrabajoObtenerREPO actividadPlanTrabajoObtenerREPO) {
        this.actividadPlanTrabajoObtenerREPO = actividadPlanTrabajoObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=actividadPlanTrabajoObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Actividad Plan Trabajo", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<ActividadPlanTrabajo> obtenerPorId(int id) {
        Optional<ActividadPlanTrabajo> respuestaBd= actividadPlanTrabajoObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Actividad Plan Trabajo", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<ActividadPlanTrabajo>> obtenerActividadesPorIdPlanTrabajo(int idPlan) {
        List<ActividadPlanTrabajo> respuestaBd= actividadPlanTrabajoObtenerREPO.obtenerActividadesPorIdPlanTrabajo(idPlan);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<ActividadPlanTrabajo>> obtenerListadoActividadesPlan() {
        List<ActividadPlanTrabajo> respuestaBd=actividadPlanTrabajoObtenerREPO.obtenerListadoActividadesPlan();
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Page<List<ListarActividadesConFiltro>>> ListarActividadesConFiltro(int pageNo, int pageSize,Integer idPlan, LocalDate fechaInicio, LocalDate fechaFin) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<List<ListarActividadesConFiltro>> respuestaBd= actividadPlanTrabajoObtenerREPO.listarActividadesConFiltro(pageable,idPlan,fechaInicio,fechaFin);
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

}
