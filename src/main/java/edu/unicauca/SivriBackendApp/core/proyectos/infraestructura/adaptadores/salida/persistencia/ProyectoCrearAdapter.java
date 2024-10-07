package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.ProyectoInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.ProyectoInfraMapperStruct;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.ProyectoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ProyectoCrearAdapter implements ProyectoCrearREPO {

    private final ProyectoRepository proyectoRepository;
    private final ProyectoInfraMapper proyectoInfraMapper;

    @Transactional
    @Override
    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoInfraMapper.toDtoSimple(proyectoRepository.save(proyectoInfraMapper.toEntityCrearProyecto(proyecto)));
    }

    @Override
    public boolean formalizarProyecto(Proyecto proyecto) {
        Optional<ProyectoEntity> antiguo = proyectoRepository.findById(proyecto.getId());

        if (antiguo.isPresent()){
            antiguo.get().setNombre(proyecto.getNombre());
            antiguo.get().setFechaInicio(proyecto.getFechaInicio());
            antiguo.get().setFechaFin(proyecto.getFechaFin());
            antiguo.get().setPlanteamiento(proyecto.getPlanteamiento());
            antiguo.get().setObjetivoGeneral(proyecto.getObjetivoGeneral());
            antiguo.get().setObjetivosEspecificos(proyecto.getObjetivosEspecificos());
            antiguo.get().setJustificacion(proyecto.getJustificacion());
            antiguo.get().setEnfoqueMetodologico(proyecto.getEnfoqueMetodologico());
            antiguo.get().setAspectosEticosLegales(proyecto.getAspectosEticosLegales());
            antiguo.get().setConfidencialidad(proyecto.getConfidencialidadDeInformacion());
            antiguo.get().setEfectosAdversos(proyecto.getEfectosAdversos());
            antiguo.get().setImpacResulEsperados(proyecto.getImpactosResultadosEsperados());
            antiguo.get().setConsideraciones(proyecto.getConsideraciones());

            proyectoRepository.save(antiguo.get());
        }

        return true;
    }

    @Override
    public boolean guardarProyecto(ProyectoEntity proyecto) {
        proyectoRepository.save(proyecto);

        return true;
    }
}
