package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Checklist;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.ChecklistEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChecklistInfraMapper {

    ChecklistEntity toEntity(Checklist dto);


}