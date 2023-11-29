package edu.unicauca.SivriBackendApp.core.grupo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.GrupoObtenerREPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
@Component
public class GrupoObtenerService implements GrupoObtenerCU {

    private final GrupoObtenerREPO grupoObtenerREPO;

    public GrupoObtenerService(GrupoObtenerREPO grupoObtenerREPO) {
        this.grupoObtenerREPO = grupoObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=grupoObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Grupo", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();

    }

    @Override
    public Respuesta<Boolean> existePorNombre(String nombre) {
        Boolean respuesta=grupoObtenerREPO.existePorNombre(nombre);
        if (respuesta){
            throw new ReglaDeNegocioException("bad.se.encontro.nombre.grupo", List.of("Grupo", "Nombre", String.valueOf(nombre)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<Grupo> obtenerGrupoPorId(int id) {
        System.out.println("INGRESA AL SERVICE DE BUSCAR GRUPO POR ID ");
        Optional<Grupo> respuestaBd = grupoObtenerREPO.obtenerGrupoPorId(id);
        if (respuestaBd.isEmpty()) {
            throw new ReglaDeNegocioException("el id " + id + " no existe.");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "Exitoso", respuestaBd.get()).getRespuesta();
    }

        @Override
    public Respuesta<List<Grupo>> obtenerGrupos() {
        List<Grupo> respuestaBd=grupoObtenerREPO.obtenerGrupos();

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("No hay grupos");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Page<Grupo>> obtenerGruposPaginado(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<Grupo> respuestaBd=grupoObtenerREPO.obtenerGruposPaginado(pageRequest);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }
}
