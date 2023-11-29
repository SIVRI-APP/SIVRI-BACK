package edu.unicauca.SivriBackendApp.core.grupo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.SubArea;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.AreasObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.AreasObtenerREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AreasObtenerService implements AreasObtenerCU {
    @Autowired
    private AreasObtenerREPO obtenerAreasREPO;

    @Override
    public Respuesta<Area> obtenerAreaPorId(int id) {
        Optional<Area> respuestaBd= obtenerAreasREPO.obtenerAreaPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("el id "+id+" no existe.");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<Area>> obtenerAreas() {
        List<Area> respuestaBd = obtenerAreasREPO.obtenerAreas();

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("No hay areas");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<SubArea>> obtenerSubAreasPorIdArea(int idArea) {
        List<SubArea> respuestaBd= obtenerAreasREPO.obtenerSubAreaPorIdArea(idArea);
        if (respuestaBd.isEmpty()) {
            throw new ReglaDeNegocioException("areas.SubaAreas.NoEncontrada");
        }
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd).getRespuesta();
    }
}
