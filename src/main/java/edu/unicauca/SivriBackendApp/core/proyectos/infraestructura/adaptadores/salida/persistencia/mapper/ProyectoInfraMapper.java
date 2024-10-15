package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.ConvocatoriaEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProyectoInfraMapper {

    public ProyectoEntity fromModelToEntityUsingIdOnly(Long id){
        ProyectoEntity entity = new ProyectoEntity();
        entity.setId(id);

        return entity;
    }

    public Proyecto fromEntityToModelCompleto(ProyectoEntity entity){
        Proyecto model = new Proyecto();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setConsideraciones(entity.getConsideraciones());
        model.setEstado(entity.getEstado());
        model.setAspectosEticosLegales(entity.getAspectosEticosLegales());
        model.setConfidencialidadDeInformacion(entity.getConfidencialidad());
        model.setEfectosAdversos(entity.getEfectosAdversos());
        model.setEliminadoLogico(entity.isEliminadoLogico());
        model.setEnfoqueMetodologico(entity.getEnfoqueMetodologico());
        model.setFechaFin(entity.getFechaFin());
        model.setFechaInicio(entity.getFechaInicio());
        model.setJustificacion(entity.getJustificacion());
        model.setImpactosResultadosEsperados(entity.getImpacResulEsperados());
        model.setPlanteamiento(entity.getPlanteamiento());
        model.setObjetivoGeneral(entity.getObjetivoGeneral());
        model.setObjetivosEspecificos(entity.getObjetivosEspecificos());

//        private Set<LineaDeInvestigacionProyecto> lineasDeInvestigacion;
//
//        private Set<IntegranteProyecto> integrantes;
//
//        private Set<EnfoqueDiferencialListado> enfoquesDiferenciales;
//
//        private Convocatoria convocatoria;
        return model;
    }

    public ProyectoEntity toEntityCrearProyecto(Proyecto proyecto) {
        ProyectoEntity entity = new ProyectoEntity();

        entity.setEliminadoLogico(false);
        entity.setEstado(proyecto.getEstado());
        entity.setNombre(proyecto.getNombre());

        return entity;
    }

    public ProyectoEntity toEntityAsociarConvocatoria(Proyecto proyecto) {
        ProyectoEntity entity = new ProyectoEntity();

        // Mapear los valores básicos
        entity.setId(proyecto.getId());
        entity.setEliminadoLogico(false); // Valor predeterminado
        entity.setEstado(proyecto.getEstado());
        entity.setNombre(proyecto.getNombre());

//         Mapear los valores adicionales
        entity.setFechaInicio(proyecto.getFechaInicio());
        entity.setFechaFin(proyecto.getFechaFin());
        entity.setPlanteamiento(proyecto.getPlanteamiento());
        entity.setObjetivoGeneral(proyecto.getObjetivoGeneral());
        entity.setObjetivosEspecificos(proyecto.getObjetivosEspecificos());
        entity.setJustificacion(proyecto.getJustificacion());
        entity.setEnfoqueMetodologico(proyecto.getEnfoqueMetodologico());
        entity.setAspectosEticosLegales(proyecto.getAspectosEticosLegales());
        entity.setConfidencialidad(proyecto.getConfidencialidadDeInformacion());
        entity.setEfectosAdversos(proyecto.getEfectosAdversos());
        entity.setImpacResulEsperados(proyecto.getImpactosResultadosEsperados());
        entity.setConsideraciones(proyecto.getConsideraciones());

        // Mapear la convocatoria (si aplica)
        if (proyecto.getConvocatoria() != null) {
            ConvocatoriaEntity convocatoriaEntity = new ConvocatoriaEntity();
            convocatoriaEntity.setId(proyecto.getConvocatoria().getId());
            entity.setConvocatoria(convocatoriaEntity);
        }

        return entity;
    }


    public Proyecto toDtoSimple(ProyectoEntity save) {
        Proyecto proyecto = new Proyecto();
        proyecto.setId(save.getId());

        return proyecto;
    }
}
