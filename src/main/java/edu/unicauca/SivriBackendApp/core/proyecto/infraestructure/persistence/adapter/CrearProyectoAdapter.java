package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.CrearProyectoREPO;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper.ProyectoInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaRepository.IProyectoRepository;
import org.springframework.stereotype.Component;

@Component
public class CrearProyectoAdapter implements CrearProyectoREPO {

    private IProyectoRepository proyectoRepository;
    private ProyectoInfraMapper proyectoInfraMapper;

    public CrearProyectoAdapter(IProyectoRepository proyectoRepository, ProyectoInfraMapper proyectoInfraMapper) {
        this.proyectoRepository = proyectoRepository;
        this.proyectoInfraMapper = proyectoInfraMapper;
    }

    @Override
    public Boolean crearProyecto(Proyecto proyecto) {
        ProyectoEntity nuevoProyecto = proyectoRepository.save(proyectoInfraMapper.obtenerEntity(proyecto));

        return proyectoRepository.existsById(nuevoProyecto.getId());
    }
}
