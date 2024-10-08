package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.RolProyectoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class RolInfraMapper {

    public RolProyecto fromEntityToModel(RolProyectoEntity entity){
        RolProyecto model = new RolProyecto();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());

        return model;
    }

    public List<RolProyecto> fromEntityListToModelList (List<RolProyectoEntity> entities){
        List<RolProyecto> models = new ArrayList<>();

        if (entities != null && !entities.isEmpty()) {
            for(RolProyectoEntity entity : entities){
                RolProyecto model = fromEntityToModel(entity);
                models.add(model);
            }
        }

        return models;
    }

    public RolProyectoEntity fromModelToEntityUsingIdOnly(Integer modelId){
        RolProyectoEntity entity = new RolProyectoEntity();
        entity.setId(modelId);

        return entity;
    }
}
