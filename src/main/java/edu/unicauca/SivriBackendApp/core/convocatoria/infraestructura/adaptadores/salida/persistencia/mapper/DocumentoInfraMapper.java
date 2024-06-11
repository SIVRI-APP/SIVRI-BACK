package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.DocumentoConvocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.DocumentoConvocatoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DocumentoInfraMapper {

    @Mappings({
            @Mapping(target = "documentacion", ignore = true)
    })
    DocumentoConvocatoriaEntity toEntity (DocumentoConvocatoria modelo);

    @Mappings({
            @Mapping(target = "documentacion", ignore = true)
    })
    DocumentoConvocatoria toModel(DocumentoConvocatoriaEntity entidad);
}
