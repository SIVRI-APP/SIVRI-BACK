package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.ProyectoInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.ProyectoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProyectoCrearAdapter implements ProyectoCrearREPO {

    private final ProyectoRepository proyectoRepository;
    private final ProyectoInfraMapper proyectoInfraMapper;

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoInfraMapper.toDto(proyectoRepository.save(proyectoInfraMapper.toEntity(proyecto)));
    }
}
