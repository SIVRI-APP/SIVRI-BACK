package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.CooperacionCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Cooperacion;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.CooperacionInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.CooperacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CooperacionCrearAdapter implements CooperacionCrearREPO {

    private final CooperacionRepository cooperacionRepository;
    private final CooperacionInfraMapper cooperacionInfraMapper;

    @Override
    public void crear(Cooperacion nuevoRegistro) {
        cooperacionRepository.save(cooperacionInfraMapper.fromModelToEntity(nuevoRegistro));
    }
}
