package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.SemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper.SemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository.ISemilleroRepository;
import org.springframework.stereotype.Component;

@Component
public class SemilleroActualizarAdapter implements SemilleroActualizarREPO {
    private final ISemilleroRepository semilleroRepository;
    private final SemilleroMapper semilleroMapper;

    public SemilleroActualizarAdapter(ISemilleroRepository semilleroRepository, SemilleroMapper semilleroMapper) {
        this.semilleroRepository = semilleroRepository;
        this.semilleroMapper = semilleroMapper;
    }

    @Override
    public Boolean actualizarPorApoyo(Semillero nuevoSemillero) {
        semilleroRepository.save(semilleroMapper.obtenerEntity(nuevoSemillero));
        return true;
    }

    @Override
    public Boolean actualizarEstadoSemillero(Semillero nuevoEstadoSemillero) {
        semilleroRepository.save(semilleroMapper.obtenerEntity(nuevoEstadoSemillero));
        return true;
    }

    @Override
    public Boolean actualizarPorMentor(Semillero nuevoSemillero) {
        semilleroRepository.save(semilleroMapper.obtenerEntity(nuevoSemillero));
        return true;
    }
}
