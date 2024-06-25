package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProyectoInfraMapperStruct {

    ProyectoEntity toEntity (Proyecto modelo);

    Proyecto toDto (ProyectoEntity entidad);
}
