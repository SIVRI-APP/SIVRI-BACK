package edu.unicauca.SivriBackendApp.core.proyecto.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ProyectoObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.ProyectoObtenerREPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoObtenerService implements ProyectoObtenerCU {

    private final ProyectoObtenerREPO proyectoObtenerREPO;

    public ProyectoObtenerService(ProyectoObtenerREPO proyectoObtenerREPO) {
        this.proyectoObtenerREPO = proyectoObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(long id) {
        Boolean respuesta = proyectoObtenerREPO.existePorId(id);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Proyecto", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<Proyecto> obtenerPorId(long id) {
        Optional<Proyecto> respuestaBd = proyectoObtenerREPO.obtenerPorId(id);

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Proyecto", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<Proyecto>> obtenerListado() {
        List<Proyecto> respuestaBd = proyectoObtenerREPO.obtenerListado();

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Page<Proyecto>> obtenerListadoPaginado(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<Proyecto> respuestaBd = proyectoObtenerREPO.obtenerListadoPaginado(pageRequest);

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }
}
