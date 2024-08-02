package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EvidenciaActividad;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.EvidenciaActividadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EvidenciaActividadMapper {
    @Mapping(source = "evidenciaActividad.id",target = "actividadId")
    EvidenciaActividad obtenerModelo(final EvidenciaActividadEntity evidenciaActividadEntity);
    @Mapping(source = "actividadId",target = "evidenciaActividad.id")
    EvidenciaActividadEntity obtenerEntity(final EvidenciaActividad evidenciaActividad);
}
