package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Departamento;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.entidad.DepartamentoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartamentoInfraMapper {

    DepartamentoEntity toEntity(Departamento modelo);

    Departamento toModel(DepartamentoEntity entidad);
}
