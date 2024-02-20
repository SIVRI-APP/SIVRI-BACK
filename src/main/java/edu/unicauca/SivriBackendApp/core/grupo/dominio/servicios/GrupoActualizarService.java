package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in.FacultadObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.Facultad;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoActualizarCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoEstado;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class GrupoActualizarService implements GrupoActualizarCU {

    private final GrupoActualizarREPO grupoActualizarREPO;
    private final GrupoObtenerCU grupoObtenerCU;
    private final FacultadObtenerCU facultadObtenerCU;
    public GrupoActualizarService(GrupoActualizarREPO grupoActualizarREPO, GrupoObtenerCU grupoObtenerCU, FacultadObtenerCU facultadObtenerCU) {
        this.grupoActualizarREPO = grupoActualizarREPO;
        this.grupoObtenerCU = grupoObtenerCU;
        this.facultadObtenerCU = facultadObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizarPorApoyo(int idGrupo, Grupo nuevosDatos) {
        Grupo objGrupoActualizar=grupoObtenerCU.obtenerGrupoPorId(idGrupo).getData();
        String nombreBd=objGrupoActualizar.getNombre();
        String nombreLlega=nuevosDatos.getNombre();
        if (!Objects.equals(nombreLlega,nombreBd)){
            grupoObtenerCU.existePorNombre(nuevosDatos.getNombre());
        }

        GrupoEstado EstadoAnt=objGrupoActualizar.getEstado();
        objGrupoActualizar.setNombre(nuevosDatos.getNombre());
        objGrupoActualizar.setFacultad(nuevosDatos.getFacultad());
        objGrupoActualizar.setDireccion(nuevosDatos.getDireccion());
        objGrupoActualizar.setTelefono(nuevosDatos.getTelefono());
        objGrupoActualizar.setEmail(nuevosDatos.getEmail());
        objGrupoActualizar.setSitioWeb(nuevosDatos.getSitioWeb());
        objGrupoActualizar.setEscalafonColciencias(nuevosDatos.getEscalafonColciencias());
        objGrupoActualizar.setDireccionGrupLac(nuevosDatos.getDireccionGrupLac());
        objGrupoActualizar.setCodigoColciencias(nuevosDatos.getCodigoColciencias());
        objGrupoActualizar.setEstado(nuevosDatos.getEstado());
        objGrupoActualizar.setCentroInvestigaciones(nuevosDatos.getCentroInvestigaciones());
        objGrupoActualizar.setMision(nuevosDatos.getMision());
        objGrupoActualizar.setVision(nuevosDatos.getVision());
        objGrupoActualizar.setObjetivo(nuevosDatos.getObjetivo());
        objGrupoActualizar.setRealizaciones(nuevosDatos.getRealizaciones());
        objGrupoActualizar.setPerspectivas(nuevosDatos.getPerspectivas());

        facultadObtenerCU.existePorId(nuevosDatos.getFacultad().getIdFacultad());
        Facultad facultad=facultadObtenerCU.obtenerPorId(nuevosDatos.getFacultad().getIdFacultad()).getData();
        objGrupoActualizar.setFacultad(facultad);
        //objGrupoActualizar.getFacultad().setIdFacultad(nuevosDatos.getFacultad().getIdFacultad());

        Boolean respuesta=grupoActualizarREPO.actualizarPorApoyo(objGrupoActualizar);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Grupo", "Id", String.valueOf(idGrupo)));
        }

        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Grupo"), "", true).getRespuesta();
    }
    @Override
    public Respuesta<Boolean> actualizarPorDirector(int idGrupo,Grupo nuevosDatos) {
        Grupo objGrupoActualizar=grupoObtenerCU.obtenerGrupoPorId(idGrupo).getData();
        GrupoEstado estado=objGrupoActualizar.getEstado();
        System.out.println("estado en service "+estado);
        if (estado==GrupoEstado.FORMULADO){
            //ACTUALIZA TODOS LOS CAMPOS DE GRUPO MENOS NOMBRE, FECHA CREACION Y ESTADO
            facultadObtenerCU.existePorId(nuevosDatos.getFacultad().getIdFacultad());
            objGrupoActualizar.setFacultad(nuevosDatos.getFacultad());
            objGrupoActualizar.setDireccion(nuevosDatos.getDireccion());
            objGrupoActualizar.setTelefono(nuevosDatos.getTelefono());
            objGrupoActualizar.setEmail(nuevosDatos.getEmail());
            objGrupoActualizar.setSitioWeb(nuevosDatos.getSitioWeb());
            objGrupoActualizar.setEscalafonColciencias(nuevosDatos.getEscalafonColciencias());
            objGrupoActualizar.setDireccionGrupLac(nuevosDatos.getDireccionGrupLac());
            objGrupoActualizar.setCodigoColciencias(nuevosDatos.getCodigoColciencias());
            objGrupoActualizar.setCentroInvestigaciones(nuevosDatos.getCentroInvestigaciones());
            objGrupoActualizar.setMision(nuevosDatos.getMision());
            objGrupoActualizar.setVision(nuevosDatos.getVision());
            objGrupoActualizar.setObjetivo(nuevosDatos.getObjetivo());
            objGrupoActualizar.setRealizaciones(nuevosDatos.getRealizaciones());
            objGrupoActualizar.setPerspectivas(nuevosDatos.getPerspectivas());
        } else if (estado==GrupoEstado.ACTIVO){
            //actualiza los siguientes campos direccion, tel, email,sitioweb.
            objGrupoActualizar.setDireccion(nuevosDatos.getDireccion());
            objGrupoActualizar.setTelefono(nuevosDatos.getTelefono());
            objGrupoActualizar.setEmail(nuevosDatos.getEmail());
            objGrupoActualizar.setSitioWeb(nuevosDatos.getSitioWeb());
        } else if (estado==GrupoEstado.INACTIVO) {
            throw new ReglaDeNegocioException("bad.error.actualizacion.grupo.inactivo",List.of("Grupo", "Id", String.valueOf(idGrupo)));
        }
        Boolean respuesta=grupoActualizarREPO.actualizarPorDirector(objGrupoActualizar);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Grupo", "Id", String.valueOf(idGrupo)));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Grupo"), "", true).getRespuesta();
    }

    /*@Override
    public Respuesta<Boolean> actualizarGrupoFormuladoPorDirector(Grupo datosGrupo) {
        Grupo objGrupoActualizar=grupoObtenerCU.obtenerGrupoPorId(datosGrupo.getId()).getData();
        GrupoEstado estado=objGrupoActualizar.getEstado();
        if (estado==GrupoEstado.FORMULADO){
            //ACTUALIZA TODOS LOS CAMPOS DE GRUPO MENOS NOMBRE, FECHA CREACION Y ESTADO
            objGrupoActualizar.setFacultad(datosGrupo.getFacultad());
            objGrupoActualizar.setDireccion(datosGrupo.getDireccion());
            objGrupoActualizar.setTelefono(datosGrupo.getTelefono());
            objGrupoActualizar.setEmail(datosGrupo.getEmail());
            objGrupoActualizar.setSitioWeb(datosGrupo.getSitioWeb());
            objGrupoActualizar.setEscalafonColciencias(datosGrupo.getEscalafonColciencias());
            objGrupoActualizar.setDireccionGrupLac(datosGrupo.getDireccionGrupLac());
            objGrupoActualizar.setCodigoColciencias(datosGrupo.getCodigoColciencias());
            objGrupoActualizar.setCentroInvestigaciones(datosGrupo.getCentroInvestigaciones());
            objGrupoActualizar.setMision(datosGrupo.getMision());
            objGrupoActualizar.setVision(datosGrupo.getVision());
            objGrupoActualizar.setObjetivo(datosGrupo.getObjetivo());
            objGrupoActualizar.setRealizaciones(datosGrupo.getRealizaciones());
            objGrupoActualizar.setPerspectivas(datosGrupo.getPerspectivas());
        }
        Boolean respuesta=grupoActualizarREPO.actualizarGrupoFormuladoPorDirector(objGrupoActualizar);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Grupo", "Id", String.valueOf(datosGrupo.getId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Grupo"), "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> actualizarGrupoActivoPorDirector(Grupo datosGrupo) {

        Grupo objGrupoActualizar=grupoObtenerCU.obtenerGrupoPorId(datosGrupo.getId()).getData();
        GrupoEstado estado=objGrupoActualizar.getEstado();
        System.out.println("ESTADO "+estado);
        if (estado==GrupoEstado.ACTIVO){
            //actualiza los siguientes campos direccion, tel, email,sitioweb.
            objGrupoActualizar.setDireccion(datosGrupo.getDireccion());
            objGrupoActualizar.setTelefono(datosGrupo.getTelefono());
            objGrupoActualizar.setEmail(datosGrupo.getEmail());
            objGrupoActualizar.setSitioWeb(datosGrupo.getSitioWeb());

        }
        System.out.println("GRUPO OBJACTUALIZAR "+objGrupoActualizar);
        Boolean respuesta=grupoActualizarREPO.actualizarGrupoActivoPorDirector(objGrupoActualizar);
        //Boolean respuesta=grupoActualizarREPO.actualizarGrupoActivoPorDirector(objGrupoActualizar);
        System.out.println("RESPUESTA: "+respuesta);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Grupo", "Id", String.valueOf(datosGrupo.getId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Grupo"), "", true).getRespuesta();
    }
*/
}
