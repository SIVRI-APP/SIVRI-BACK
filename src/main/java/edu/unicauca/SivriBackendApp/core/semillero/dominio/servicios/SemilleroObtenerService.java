package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.email.dto.MetaData;
import edu.unicauca.SivriBackendApp.common.email.dto.SendRequest;
import edu.unicauca.SivriBackendApp.common.email.service.SendMessageService;
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
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioInformacionDetalladaProyeccion;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SemilleroObtenerService implements SemilleroObtenerCU {

    private final SemilleroObtenerREPO semilleroObtenerREPO;
    private final ServicioDeIdentificacionDeUsuario servicioDeIdentificacionDeUsuario;
    private final SendMessageService sendMessageService;
   // private final SemilleroObtenerCU semilleroObtenerCU;
    private final UsuarioObtenerCU usuarioObtenerCU;
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
            throw new ReglaDeNegocioException("bad.semillero.no.existe",List.of("id",String.valueOf(id)));
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
    public Respuesta<Boolean> envioEmailRevisionVri(Integer semilleroId) {
        //ontener el semillero
        Optional<Semillero> semillero= semilleroObtenerREPO.obtenerSemilleroPorId(semilleroId);
        //obtener el ususario
        Respuesta<UsuarioInformacionDetalladaProyeccion> usuario= usuarioObtenerCU.obtenerUsuarioInformacionDetallada(servicioDeIdentificacionDeUsuario.obtenerUsuario().getId());
        //enviar email
        //TODO SE DEBE CAMBIAR EL CORREO POR EL DE EL ADMINISTRADOR DEL SEMILLERO
        if(semillero.isPresent()){
            SendRequest datosenvio=new SendRequest("yuranyguev@unicauca.edu.co","Notificación de registro de semillero",4, List.of(new MetaData("semilleroId",semilleroId.toString()),new MetaData("nombreSemillero",semillero.get().getNombre()),new MetaData("nombreUsuario",usuario.getData().getNombre()+" "+usuario.getData().getApellido())));
            sendMessageService.sendMessage(datosenvio);
            return new RespuestaHandler<>(200,"sucess.operacion.exitosa.revisionVri","Exitoso",true).getRespuesta();
        }else {
            return new RespuestaHandler<>(400,"bad.error.envio.revisionVri","No exitoso",false).getRespuesta();
        }
    }
    //@Override
    public Respuesta<Boolean> notificacionCorreoMentorSemillero(Integer semilleroId,String nombreSemillero,long mentorId) {
        //obtener el ususario
        Respuesta<UsuarioInformacionDetalladaProyeccion> usuarioMentor= usuarioObtenerCU.obtenerUsuarioInformacionDetallada(mentorId);
        Respuesta<UsuarioInformacionDetalladaProyeccion> usuarioDirector= usuarioObtenerCU.obtenerUsuarioInformacionDetallada(servicioDeIdentificacionDeUsuario.obtenerUsuario().getId());
        //enviar email
        SendRequest datosEnvio=new SendRequest(usuarioMentor.getData().getCorreo(),"Notificación de asignacion como Mentor de un semillero",5,List.of(new MetaData("semilleroId",semilleroId.toString()),new MetaData("nombreSemillero",nombreSemillero),new MetaData("nombreDirector",usuarioDirector.getData().getNombre()+" "+usuarioDirector.getData().getApellido())));
        sendMessageService.sendMessage(datosEnvio);
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa.notificacion.mentor.semillero","Exitoso",true).getRespuesta();
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

}
