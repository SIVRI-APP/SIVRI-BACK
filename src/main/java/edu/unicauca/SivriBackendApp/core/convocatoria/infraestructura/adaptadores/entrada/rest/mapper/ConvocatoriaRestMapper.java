package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.dto.peticion.CrearConvocatoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ConvocatoriaRestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "checklist", ignore = true)
    Convocatoria crearConvocatoriaDTO(CrearConvocatoriaDTO dto);

}
