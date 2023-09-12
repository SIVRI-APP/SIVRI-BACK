package edu.unicauca.SivriBackendApp.core.proyecto.domain.service;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ActualizarProyectoCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ObtenerProyectosCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.ActualizarProyectoREPO;
import org.springframework.stereotype.Component;

@Component
public class ActualizarProyectoService implements ActualizarProyectoCU {
    private ActualizarProyectoREPO actualizarProyectoREPO;
    private ObtenerProyectosCU obtenerProyectosCU;

    public ActualizarProyectoService(ActualizarProyectoREPO actualizarProyectoREPO, ObtenerProyectosCU obtenerProyectosCU) {
        this.actualizarProyectoREPO = actualizarProyectoREPO;
        this.obtenerProyectosCU = obtenerProyectosCU;
    }

    @Override
    public Respuesta<Boolean> actualizarProyecto(Proyecto proyecto) {
        Proyecto proyectoViejo = obtenerProyectosCU.obtenerProyectoPorId(proyecto.getId()).getData();

        proyectoViejo.setNombre(proyecto.getNombre());
        proyectoViejo.setFechaInicio(proyecto.getFechaInicio());
        proyectoViejo.setFechaFin(proyecto.getFechaFin());
        proyectoViejo.setPlanteamiento(proyecto.getPlanteamiento());
        proyectoViejo.setObjetivoGeneral(proyecto.getObjetivoGeneral());
        proyectoViejo.setObjetivosEspecificos(proyecto.getObjetivosEspecificos());
        proyectoViejo.setJustificacion(proyecto.getJustificacion());
        proyectoViejo.setEnfoqueMetodologico(proyecto.getEnfoqueMetodologico());
        proyectoViejo.setAspectosEticosLegales(proyecto.getAspectosEticosLegales());
        proyectoViejo.setConfidencialidadDeInformacion(proyecto.getConfidencialidadDeInformacion());
        proyectoViejo.setEfectosAdversos(proyecto.getEfectosAdversos());
        proyectoViejo.setImpactosResultadosEsperados(proyecto.getImpactosResultadosEsperados());
        proyectoViejo.setConsideraciones(proyecto.getConsideraciones());

        return new RespuestaHandler<>(200, "Actualización exitosa", "", actualizarProyectoREPO.actualizarProyecto(proyectoViejo)).getRespuesta();
    }
}
