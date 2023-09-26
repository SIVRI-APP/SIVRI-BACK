package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.adapter;


import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.ProyectoCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper.ProyectoInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaRepository.IProyectoRepository;
import org.springframework.stereotype.Component;

@Component
public class ProyectoCrearAdapter implements ProyectoCrearREPO {

    private final IProyectoRepository proyectoRepository;
    private final ProyectoInfraMapper proyectoInfraMapper;

    public ProyectoCrearAdapter(IProyectoRepository proyectoRepository, ProyectoInfraMapper proyectoInfraMapper) {
        this.proyectoRepository = proyectoRepository;
        this.proyectoInfraMapper = proyectoInfraMapper;
    }

    @Override
    public Boolean crear(Proyecto nuevosDatos) {
        proyectoRepository.save(proyectoInfraMapper.obtenerEntity(nuevosDatos));
        return true;
    }
}
