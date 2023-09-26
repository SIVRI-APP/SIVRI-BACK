package edu.unicauca.SivriBackendApp.core.proyecto.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaActualizarCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.TipoFinanciacionObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out.ConvocatoriaActualizarREPO;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ProyectoActualizarCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ProyectoObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.ProyectoActualizarREPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProyectoActualizarService implements ProyectoActualizarCU {
    private final ProyectoActualizarREPO proyectoActualizarREPO;
    private final ProyectoObtenerCU proyectoObtenerCU;
    private final ConvocatoriaObtenerCU convocatoriaObtenerCU;

    public ProyectoActualizarService(ProyectoActualizarREPO proyectoActualizarREPO, ProyectoObtenerCU proyectoObtenerCU, ConvocatoriaObtenerCU convocatoriaObtenerCU) {
        this.proyectoActualizarREPO = proyectoActualizarREPO;
        this.proyectoObtenerCU = proyectoObtenerCU;
        this.convocatoriaObtenerCU = convocatoriaObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizar(Proyecto nuevosDatos) {

        Proyecto objetoParaActualizar = proyectoObtenerCU.obtenerPorId(nuevosDatos.getId()).getData();

        // Crear un arreglo de strings con los nombres de las propiedades a excluir
        String[] propiedadesAExcluir = {"id", "lineasDeInvestigacion", "integrantes", "enfoquesDiferenciales"};

        BeanUtils.copyProperties(nuevosDatos, objetoParaActualizar, propiedadesAExcluir);

        boolean respuesta = proyectoActualizarREPO.actualizar(objetoParaActualizar);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Proyecto", "Id", String.valueOf(nuevosDatos.getId())));
        }

        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Proyecto"), "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> asociarProyectoAconvocaotira(Long idProyecto, Long idConvocatoria) {
        Proyecto objetoParaActualizar = proyectoObtenerCU.obtenerPorId(idProyecto).getData();
        Convocatoria objetoConvocatoria = convocatoriaObtenerCU.obtenerPorId(idConvocatoria).getData();


        objetoParaActualizar.setConvocatoria(objetoConvocatoria);

        proyectoActualizarREPO.actualizar(objetoParaActualizar);

        return new RespuestaHandler<>(200, "sucess.asociar.proyecto.convocatoria", List.of(objetoParaActualizar.getNombre(), objetoConvocatoria.getNombre()), "", true).getRespuesta();
    }
}
