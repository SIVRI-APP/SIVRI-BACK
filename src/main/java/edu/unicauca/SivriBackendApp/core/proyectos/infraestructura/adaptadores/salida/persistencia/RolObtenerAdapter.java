package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.RolObtenerREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.RolProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.RolInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class RolObtenerAdapter implements RolObtenerREPO {

    private final RolRepository rolRepository;
    private final RolInfraMapper rolInfraMapper;

    @Override
    public Optional<RolProyecto> obtenerProyectoPorId(long proyectoId) {

        Optional<RolProyectoEntity> rolEntity = rolRepository.findById(proyectoId);

        return rolEntity.map(rolInfraMapper::fromEntityToModel);

    }

    @Override
    public Optional<RolProyecto> obtenerRolPorEnum(RolProyectoEnum proyectoId) {
        
        Optional<RolProyectoEntity> rolEntity = rolRepository.findByNombre(proyectoId);

        return rolEntity.map(rolInfraMapper::fromEntityToModel);

    }
}
