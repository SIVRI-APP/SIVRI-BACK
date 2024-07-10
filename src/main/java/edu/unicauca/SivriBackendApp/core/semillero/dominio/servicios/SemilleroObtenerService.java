package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificacionDeUsuario;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.SemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroSemilleros;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarSemilleroPorIdMentor;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarSemillerosConFiltroxMentor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SemilleroObtenerService implements SemilleroObtenerCU {

    private final SemilleroObtenerREPO semilleroObtenerREPO;
    private final ServicioDeIdentificacionDeUsuario servicioDeIdentificacionDeUsuario;


    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=semilleroObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Semillero", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> existePorNombre(String nombre) {
        Boolean respuesta=semilleroObtenerREPO.existePorNombre(nombre);
        if (respuesta){
            throw new ReglaDeNegocioException("bad.se.encontro.nombre.semillero", List.of("Semillero", "Nombre", String.valueOf(nombre)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<Semillero> obtenerSemilleroPorId(int id) {

        Optional<Semillero> respuesta=semilleroObtenerREPO.obtenerSemilleroPorId(id);
        if (respuesta.isEmpty()) {
            throw new ReglaDeNegocioException("el id " + id + " no existe.");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "Exitoso", respuesta.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<Semillero>> obtenerSemillerosPorIdGrupo(int idGrupo) {
        List<Semillero> respuesta=semilleroObtenerREPO.obtenerSemillerosPorIdGrupo(idGrupo);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();
    }

    @Override
    public Respuesta<List<Semillero>> obtenerSemillerosPorIdDirectorGrupo(long idDirector) {
        List<Semillero> respuesta=semilleroObtenerREPO.obtenerSemillerosPorIdDirectorGrupo(idDirector);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros");
        }
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();
    }

    @Override
    public Respuesta<List<Semillero>> obtenerSemilleros() {
        List<Semillero> respuesta=semilleroObtenerREPO.obtenerSemilleros();
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();
    }

    @Override
    public Respuesta<Page<Semillero>> obtenerSemillerosPaginado(int pageNo, int pageSize) {
        PageRequest pageRequest=PageRequest.of(pageNo, pageSize);
        Page<Semillero> respuestaBd= semilleroObtenerREPO.obtenerListadoSemilleroPaginado(pageRequest);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Page<List<ListarConFiltroSemilleros>>> listarSemillerosConfiltro(int pageNo, int pageSize, String nombre, String correo, SemilleroEstado estado) {
       Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<List<ListarConFiltroSemilleros>> respuestaBd= semilleroObtenerREPO.listarSemillerosConfiltro(pageable, nombre, correo, estado);
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Page<List<ListarSemillerosConFiltroxMentor>>> listarSemilleroConFiltroxMentor(int pageNo, int pageSize, Integer semilleroId, String nombre, SemilleroEstado estado) {
        System.out.println("lleg al service");
        Long usuarioId=servicioDeIdentificacionDeUsuario.obtenerUsuario().getId();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<List<ListarSemillerosConFiltroxMentor>> respuestaBd= semilleroObtenerREPO.listarSemilleroConFiltroxMentor(pageable,semilleroId,usuarioId,nombre,estado);
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","",respuestaBd).getRespuesta();
    }
    @Override
    public Respuesta<Page<List<ListarSemilleroPorIdMentor>>> obtenerSemillerosConFiltroxIdDirector(int pageNo, int pageSize, Integer semilleroId, String nombre, SemilleroEstado estado) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Long usuarioId=servicioDeIdentificacionDeUsuario.obtenerUsuario().getId();

        Page<List<ListarSemilleroPorIdMentor>> respuestaBd=semilleroObtenerREPO.obtenerSemillerosConFiltroxIdDirector(pageable,semilleroId,usuarioId,nombre,estado);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros.mentor");
        }
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd).getRespuesta();
    }
    @Override
    public Respuesta<Page<List<ListarSemilleroPorIdMentor>>> obtenerSemillerosPorIdMentor(int pageNo, int pageSize, int idMentor) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        //TODO falta verificar que el id que ingresa tenga el rol de mentor o director
        Page<List<ListarSemilleroPorIdMentor>> respuestaBd=semilleroObtenerREPO.obtenerSemillerosPorIdMentor(pageable,idMentor);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros.mentor");
        }
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd).getRespuesta();
    }



    /*@Override
    public Respuesta<List<Semillero>> obtenerSemillerosPorIdMentor(String idMentor) {
        List<Semillero> respuesta=semilleroObtenerREPO.obtenerSemillerosPorIdMentor(idMentor);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros.mentor");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();

    }*/

}
