package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.CompromisoSemillero;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.respuesta.CompromisoSemilleroObtenerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompromisoSemilleroDtoMapper {
    CompromisoSemilleroObtenerDTO obtenerCompromisos(final CompromisoSemillero compromisoSemilleroModel);

}
