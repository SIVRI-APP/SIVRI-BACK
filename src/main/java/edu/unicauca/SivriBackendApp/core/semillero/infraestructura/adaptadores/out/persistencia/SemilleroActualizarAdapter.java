package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.SemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.SemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.ISemilleroRepository;
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
        System.out.println("DATOS QUE LLEGAN ALADAPTER "+nuevoEstadoSemillero);
        semilleroRepository.save(semilleroMapper.obtenerEntity(nuevoEstadoSemillero));
        return true;
    }

    @Override
    public Boolean actualizarPorMentor(Semillero nuevoSemillero) {
        semilleroRepository.save(semilleroMapper.obtenerEntity(nuevoSemillero));
        return true;
    }
}
