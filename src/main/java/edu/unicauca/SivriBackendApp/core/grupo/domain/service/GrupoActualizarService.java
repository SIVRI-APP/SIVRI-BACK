package edu.unicauca.SivriBackendApp.core.grupo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.FacultadObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoEstado;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoActualizarCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.GrupoActualizarREPO;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public Respuesta<Boolean> actualizarPorApoyo(Grupo nuevosDatos) {
        Grupo objGrupoActualizar=grupoObtenerCU.obtenerGrupoPorId(nuevosDatos.getId()).getData();

        objGrupoActualizar.setNombre(nuevosDatos.getNombre());
        objGrupoActualizar.setFacultad(nuevosDatos.getFacultad());
        objGrupoActualizar.setDireccion(nuevosDatos.getDireccion());
        objGrupoActualizar.setTelefono(nuevosDatos.getTelefono());
        objGrupoActualizar.setEmail(nuevosDatos.getEmail());
        //objGrupoActualizar.documento del director
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
        objGrupoActualizar.getFacultad().setIdFacultad(nuevosDatos.getFacultad().getIdFacultad());

        Boolean respuesta=grupoActualizarREPO.actualizarPorApoyo(objGrupoActualizar);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Grupo", "Id", String.valueOf(nuevosDatos.getId())));
        }

        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Grupo"), "", true).getRespuesta();
    }
    @Override
    public Respuesta<Boolean> actualizarPorDirector(Grupo nuevosDatos) {
        Grupo objGrupoActualizar=grupoObtenerCU.obtenerGrupoPorId(nuevosDatos.getId()).getData();
        GrupoEstado estado=objGrupoActualizar.getEstado();
        if (estado==GrupoEstado.FORMULADO){
            //ACTUALIZA TODOS LOS CAMPOS DE GRUPO MENOS NOMBRE, FECHA CREACION Y ESTADO
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
        }else {
            //actualiza los siguientes campos direccion, tel, email,sitioweb.
            objGrupoActualizar.setDireccion(nuevosDatos.getDireccion());
            objGrupoActualizar.setTelefono(nuevosDatos.getTelefono());
            objGrupoActualizar.setEmail(nuevosDatos.getEmail());
            objGrupoActualizar.setSitioWeb(nuevosDatos.getSitioWeb());
        }
        Boolean respuesta=grupoActualizarREPO.actualizarPorDirector(objGrupoActualizar);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Grupo", "Id", String.valueOf(nuevosDatos.getId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Grupo"), "", true).getRespuesta();
    }

    @Override
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

}
