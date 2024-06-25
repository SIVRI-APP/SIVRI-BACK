package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.RolProyectoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RolInfraMapper {

    public RolProyecto fromEntityToModel(RolProyectoEntity entity){
        RolProyecto model = new RolProyecto();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());

        return model;
    }

    public RolProyectoEntity fromModelToEntityUsingIdOnly(Integer modelId){
        RolProyectoEntity entity = new RolProyectoEntity();
        entity.setId(modelId);

        return entity;
    }
}
