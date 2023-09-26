package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.ProyectoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper.ProyectoInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaRepository.IProyectoRepository;
import org.springframework.stereotype.Component;

@Component
public class ProyectoActualizarAdapter implements ProyectoActualizarREPO {

    private final IProyectoRepository proyectoRepository;
    private final ProyectoInfraMapper proyectoInfraMapper;

    public ProyectoActualizarAdapter(IProyectoRepository proyectoRepository, ProyectoInfraMapper proyectoInfraMapper) {
        this.proyectoRepository = proyectoRepository;
        this.proyectoInfraMapper = proyectoInfraMapper;
    }

    @Override
    public Boolean actualizar(Proyecto nuevosDatos) {
        proyectoRepository.save(proyectoInfraMapper.obtenerEntity(nuevosDatos));
        return true;
    }
}
