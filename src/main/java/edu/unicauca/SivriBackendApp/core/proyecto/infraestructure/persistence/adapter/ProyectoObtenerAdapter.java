package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.ProyectoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper.ProyectoInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaRepository.IProyectoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProyectoObtenerAdapter implements ProyectoObtenerREPO {

    private final IProyectoRepository proyectoRepository;
    private final ProyectoInfraMapper proyectoInfraMapper;

    public ProyectoObtenerAdapter(IProyectoRepository proyectoRepository, ProyectoInfraMapper proyectoInfraMapper) {
        this.proyectoRepository = proyectoRepository;
        this.proyectoInfraMapper = proyectoInfraMapper;
    }

    @Override
    public Boolean existePorId(long id) {
        return proyectoRepository.existsById(id);
    }

    @Override
    public Optional<Proyecto> obtenerPorId(long id) {
        Optional<ProyectoEntity> respuestaJpa = proyectoRepository.findById(id);

        return respuestaJpa.map(proyectoInfraMapper::fullInfoProyecto);
    }

    @Override
    public List<Proyecto> obtenerListado() {
        return proyectoRepository.findAll().stream().map(proyectoInfraMapper::fullInfoProyecto).collect(Collectors.toList());
    }

    @Override
    public Page<Proyecto> obtenerListadoPaginado(PageRequest pageRequest) {
        return proyectoRepository.findAll(pageRequest).map(proyectoInfraMapper::fullInfoProyecto);
    }
}
