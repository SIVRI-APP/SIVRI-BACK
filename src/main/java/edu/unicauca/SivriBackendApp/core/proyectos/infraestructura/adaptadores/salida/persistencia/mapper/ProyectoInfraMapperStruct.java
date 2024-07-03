package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProyectoInfraMapperStruct {

    ProyectoEntity toEntity (Proyecto modelo);

    @Mapping(target = "integrantes", ignore = true)
    @Mapping(target = "convocatoria.checklist", ignore = true)
    Proyecto toDto (ProyectoEntity entidad);
}
