package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ObtenerProyectosCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.ActualizarProyectoREPO;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper.ProyectoInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaRepository.IProyectoRepository;
import org.springframework.stereotype.Component;

@Component
public class ActualizarProyectoAdapter implements ActualizarProyectoREPO {

    private IProyectoRepository proyectoRepository;
    private ProyectoInfraMapper proyectoInfraMapper;

    public ActualizarProyectoAdapter(IProyectoRepository proyectoRepository, ProyectoInfraMapper proyectoInfraMapper) {
        this.proyectoRepository = proyectoRepository;
        this.proyectoInfraMapper = proyectoInfraMapper;
    }

    @Override
    public Boolean actualizarProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyectoInfraMapper.obtenerEntity(proyecto));
        return true;
    }
}
