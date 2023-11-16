package edu.unicauca.SivriBackendApp.core.semillero.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.SemilleroObtenerREPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SemilleroObtenerService implements SemilleroObtenerCU {
    private final SemilleroObtenerREPO semilleroObtenerREPO;

    public SemilleroObtenerService(SemilleroObtenerREPO semilleroObtenerREPO) {
        this.semilleroObtenerREPO = semilleroObtenerREPO;
    }

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



    /*@Override
    public Respuesta<Optional<Semillero>> obtenerSemillerosPorIdONombre(SemilleroObtenerIdONombreDTO semillero) {
        System.out.println("idSemillero "+semillero.getSemilleroId()+" nombre "+semillero.getNombre());
        int idSemillero=semillero.getSemilleroId();
        String nombre=semillero.getNombre();
        Optional<Semillero> respuesta = semilleroObtenerREPO.obtenerSemilleroPorIdOrNombre(idSemillero,nombre);
        if (idSemillero != 0){
            respuesta=semilleroObtenerREPO.obtenerSemilleroPorId(idSemillero);
            if (respuesta.isEmpty()) {
                throw new ReglaDeNegocioException("el id " + idSemillero + " no existe.");
            }
        } else if (nombre != null) {
            respuesta=semilleroObtenerREPO.obtenerSemilleroPorIdOrNombre(idSemillero,nombre);
            if (respuesta.isEmpty()) {
                throw new ReglaDeNegocioException("el nombre " + nombre + " no existe.");
            }
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "Exitoso", respuesta).getRespuesta();
    }
*/
    /*@Override
    public Respuesta<List<Semillero>> obtenerSemillerosPorIdAndNombre(int idSemillero, String nombre) {
        System.out.println("id semillero "+idSemillero+" nombre "+nombre);
        if (nombre.isBlank()){
            //busca por ids
        }else {
            //busca por nombre
            System.out.println("ingresaa buscar por nombre");
            List<Semillero> respuesta=semilleroObtenerREPO.obtenerSemilleroPorNombre(nombre);
        }
        List<Semillero> respuesta=semilleroObtenerREPO.obtenerSemilleroPorIdAndNombre(idSemillero,nombre);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros");
        }
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();

    }*/

    /*@Override
    public Respuesta<List<Semillero>> obtenerSemillerosPorIdOrNombre(String dato) {
        List<Semillero> respuesta= (List<Semillero>) semilleroObtenerREPO;
        if (StringUtils.hasText(dato)){
            int dato1=Integer.parseInt(dato);
            if (JdbcUtils.isNumeric(dato1)){
                //dato numerico

            }else {
                //dato string
                respuesta = semilleroObtenerREPO.obtenerSemilleroPorNombre(dato);
            }
        }else {
            //dato vacio
            System.out.println("dato vacio");
        }
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros");
        }
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();
    }*/

    @Override
    public Respuesta<List<Semillero>> obtenerSemillerosPorIdGrupo(int idGrupo) {
        List<Semillero> respuesta=semilleroObtenerREPO.obtenerSemillerosPorIdGrupo(idGrupo);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();
    }

    /*@Override
    public Respuesta<List<Semillero>> obtenerSemillerosPorIdMentor(String idMentor) {
        List<Semillero> respuesta=semilleroObtenerREPO.obtenerSemillerosPorIdMentor(idMentor);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros.mentor");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();

    }*/

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

}
