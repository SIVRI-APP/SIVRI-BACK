package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.LineaInvestigacionCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.ObservacionSemilleroCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.ObservacionSemilleroObtenerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObservacionSemilleroDtoMapper {
    ObservacionSemilleroObtenerDTO obtenerObservacionSemillero(final ObservacionSemillero observacionSemillero);
    ObservacionSemillero asociarObservacion(final ObservacionSemilleroCrearDTO observacionSemilleroCrearDTO);
    ObservacionSemillero actualizarObservacionSemillero(final ObservacionSemilleroCrearDTO observacionSemilleroActualizarDTO);
}
