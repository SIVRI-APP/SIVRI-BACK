package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProyectoInfraMapper {

    public ProyectoEntity fromModelToEntityUsingIdOnly(Long id){
        ProyectoEntity entity = new ProyectoEntity();
        entity.setId(id);

        return entity;
    }
}
