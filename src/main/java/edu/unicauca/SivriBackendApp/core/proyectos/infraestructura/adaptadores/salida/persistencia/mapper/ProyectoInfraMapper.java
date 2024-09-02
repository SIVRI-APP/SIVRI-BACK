package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper;

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
        model.setConfidencialidadDeInformacion(entity.getConfidencialidadDeInformacion());
        model.setEfectosAdversos(entity.getEfectosAdversos());
        model.setEliminadoLogico(entity.isEliminadoLogico());
        model.setEnfoqueMetodologico(entity.getEnfoqueMetodologico());
        model.setFechaFin(entity.getFechaFin());
        model.setFechaInicio(entity.getFechaInicio());
        model.setJustificacion(entity.getJustificacion());
        model.setImpactosResultadosEsperados(entity.getImpactosResultadosEsperados());
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
}
