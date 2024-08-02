package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EvidenciaActividad;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.respuesta.EvidenciaActividadDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EvidenciaActividadDtoMapper {
    EvidenciaActividadDTO obtenerEvidenciaActividad(final EvidenciaActividad obtenerModelo);
}
