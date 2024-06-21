package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoEstado;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarGruposConFiltro;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarGruposPorIdDirector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Boolean respuesta = grupoObtenerREPO.existePorId(id);
        if (!respuesta) {
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Grupo", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> existePorNombre(String nombre) {
        Boolean respuesta = grupoObtenerREPO.existePorNombre(nombre);
        if (respuesta) {
            throw new ReglaDeNegocioException("bad.se.encontro.nombre.grupo", List.of("Grupo", "Nombre", String.valueOf(nombre)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", true).getRespuesta();
    }

    @Override
    public Respuesta<Grupo> obtenerGrupoPorId(int id) {
        System.out.println("INGRESA AL SERVICE DE BUSCAR GRUPO POR ID ");
        Optional<Grupo> respuestaBd = grupoObtenerREPO.obtenerGrupoPorId(id);
        System.out.println("respuestabd"+ respuestaBd);
        if (respuestaBd.isEmpty()) {
            throw new ReglaDeNegocioException("el id " + id + " no existe.");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "Exitoso", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<Grupo>> obtenerGrupos() {
        List<Grupo> respuestaBd = grupoObtenerREPO.obtenerGrupos();

        if (respuestaBd.isEmpty()) {
            throw new ReglaDeNegocioException("No hay grupos");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "Exitoso", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Page<Grupo>> obtenerGruposPaginado(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<Grupo> respuestaBd = grupoObtenerREPO.obtenerGruposPaginado(pageRequest);
        if (respuestaBd.isEmpty()) {
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<ListarGruposPorIdDirector>> obtenerGruposPorIdDirector(int idDirector) {

        List<ListarGruposPorIdDirector> respuestaBd= grupoObtenerREPO.obtenerGruposPorIdDirector(idDirector);
        if (respuestaBd.isEmpty()) {
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.grupos.director ");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "Exitoso", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Page<List<ListarGruposPorIdDirector>>> obtenerGruposPorIdDirectorPaginado(int pageNo, int pageSize, int idDirector) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        //TODO validar que el usuario sea director
        Page<List<ListarGruposPorIdDirector>> respuestaBd = grupoObtenerREPO.obtenerGruposPorIdDirectorPaginado(pageable, idDirector);
        if (respuestaBd.isEmpty()) {
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.grupos.director");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "Exitoso", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Page<List<ListarGruposConFiltro>>> obtenerGruposConFiltro(int pageNo, int pageSize, String nombre, GrupoEstado estado, String facultad, String director) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<List<ListarGruposConFiltro>> respuestaBd = grupoObtenerREPO.obtenerGruposConFiltro(pageable, nombre, estado, facultad, director);

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }
}
