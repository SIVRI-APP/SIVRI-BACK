package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.IntegranteSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.IntegranteSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroIntegrantesSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarIntegrantesSemilleroxIdSemillero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class IntegranteSemilleroObtenerService implements IntegranteSemilleroObtenerCU {
    private final IntegranteSemilleroObtenerREPO integranteSemilleroObtenerREPO;

    public IntegranteSemilleroObtenerService(IntegranteSemilleroObtenerREPO integranteSemilleroObtenerREPO) {
        this.integranteSemilleroObtenerREPO = integranteSemilleroObtenerREPO;
    }

    @Override
    public Respuesta<IntegranteSemillero> obtenerPorId(int id) {
        Optional<IntegranteSemillero> respuestaBd=integranteSemilleroObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Integrante Semillero", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<Page<IntegranteSemillero>> obtenerListadoIntegrantesSemilleroPaginado(int pageNo, int pageSize) {
        PageRequest pageRequest=PageRequest.of(pageNo, pageSize);
        Page<IntegranteSemillero> respuestaBd=integranteSemilleroObtenerREPO.obtenerListadoIntegrantesSemilleroPaginado(pageRequest);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.integrantes.semilleros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<IntegranteSemillero>> obtenerIntegranteSemilleroPorIdSemillero(int idSemillero) {
        List<IntegranteSemillero> respuesta=integranteSemilleroObtenerREPO.obtenerIntegranteSemilleroPorIdSemillero(idSemillero);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.integrantes.semilleros");
        }
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();
    }

    @Override
    public Respuesta<Page<List<ListarIntegrantesSemilleroxIdSemillero>>> obtenerIntegrantesSemilleroPorIdSemillero(int pageNo, int pageSize, int idSemillero, String numeroDocumento, String rolSemillero, EstadoIntegranteSemillero estado) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<List<ListarIntegrantesSemilleroxIdSemillero>> respuestaBd=integranteSemilleroObtenerREPO.obtenerIntegrantesSemilleroPorIdSemillero(pageable,idSemillero,numeroDocumento,rolSemillero,estado);
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }


    @Override
    public Respuesta<List<Semillero>> obtenerSemillerosPorIdMentor(String idMentor) {
        System.out.println("ENTRA A SERVICE ");
        List<Semillero> respuesta=integranteSemilleroObtenerREPO.obtenerSemillerosPorIdMentor(idMentor);
        //System.out.println("respuesta de service "+respuesta);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros.mentor");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();

    }

    @Override
    public Respuesta<Page<List<ListarConFiltroIntegrantesSemillero>>> listarIntegrantesSemilleroConFiltro(int pageNo, int pageSize, String numeroDocumento, String rolSemillero, EstadoIntegranteSemillero estado/*, String programa*/) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<List<ListarConFiltroIntegrantesSemillero>> respuestaBd= integranteSemilleroObtenerREPO.listarIntegrantesSemilleroConFiltro(pageable,numeroDocumento,rolSemillero,estado);
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }


    /* @Override
    public Respuesta<List<IntegranteSemillero>> obtenerIntegrantesSemillero() {

        List<IntegranteSemillero> respuestaBd=integranteSemilleroObtenerREPO.obtenerIntegrantesSemillero();

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }*/

}
