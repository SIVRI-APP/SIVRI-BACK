package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.ObtenerProyectosREPO;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper.ProyectoMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaRepository.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ObtenerProyectosAdapter implements ObtenerProyectosREPO {
    @Autowired
    IProyectoRepository proyectoRepository;

    @Autowired
    ProyectoMapper proyectoMapper;

    @Override
    public Optional<Proyecto> obtenerProyectoPorId(int id) {
        Optional<ProyectoEntity> respuestaJpa = proyectoRepository.findById(id);

        if (respuestaJpa.isPresent()) {
            return Optional.of(proyectoMapper.obtenerModelo(respuestaJpa.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<Proyecto> obtenerProyectos() {
        return this.proyectoRepository.findAll().stream().map(proyectoEntity -> {
            Proyecto proyecto = proyectoMapper.obtenerModelo(proyectoEntity);
            return proyecto;
        }).collect(Collectors.toList());
    }
}
