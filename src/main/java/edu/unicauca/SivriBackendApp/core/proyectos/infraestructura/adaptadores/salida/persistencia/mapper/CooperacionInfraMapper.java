package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Cooperacion;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.CooperacionEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CooperacionInfraMapper {

    private final ProyectoInfraMapper proyectoInfraMapper;

    public CooperacionEntity fromModelToEntity(Cooperacion model){
        CooperacionEntity entity = new CooperacionEntity();
        entity.setEstado(model.getEstado());
        entity.setFechaFin(model.getFechaFin());
        entity.setFechaInicio(model.getFechaInicio());
        entity.setEstado(model.getEstado());
        entity.setPrincipal(model.getPrincipal());
        entity.setProyecto(proyectoInfraMapper.fromModelToEntityUsingIdOnly(model.getProyecto().getId()));
        // todo miguel cuando integre con Yurani
//        entity.setOrganismoDeInvestigacion();
        return entity;
    }
}
