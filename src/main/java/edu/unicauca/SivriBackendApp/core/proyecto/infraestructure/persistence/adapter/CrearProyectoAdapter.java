package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.CrearProyectoREPO;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper.ProyectoMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaRepository.IProyectoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CrearProyectoAdapter implements CrearProyectoREPO {

    private IProyectoRepository proyectoRepository;
    private ProyectoMapper proyectoMapper;

    public CrearProyectoAdapter(IProyectoRepository proyectoRepository, ProyectoMapper proyectoMapper) {
        this.proyectoRepository = proyectoRepository;
        this.proyectoMapper = proyectoMapper;
    }

    @Override
    public Boolean crearProyecto(Proyecto proyecto) {
        ProyectoEntity nuevoProyecto = proyectoRepository.save(proyectoMapper.obtenerEntity(proyecto));

        return proyectoRepository.existsById(nuevoProyecto.getId());
    }
}
