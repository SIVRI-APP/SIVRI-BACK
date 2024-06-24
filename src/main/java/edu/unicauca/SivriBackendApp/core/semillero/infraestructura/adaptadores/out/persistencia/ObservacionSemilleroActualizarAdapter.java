package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.ObservacionSemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.ObservacionSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IObservacionSemilleroRepository;
import org.springframework.stereotype.Component;

@Component
public class ObservacionSemilleroActualizarAdapter implements ObservacionSemilleroActualizarREPO {
    private final IObservacionSemilleroRepository observacionSemilleroRepository;
    private final ObservacionSemilleroMapper observacionSemilleroMapper;

    public ObservacionSemilleroActualizarAdapter(IObservacionSemilleroRepository observacionSemilleroRepository, ObservacionSemilleroMapper observacionSemilleroMapper) {
        this.observacionSemilleroRepository = observacionSemilleroRepository;
        this.observacionSemilleroMapper = observacionSemilleroMapper;
    }

    @Override
    public Boolean actualizarObservacionSemillero(ObservacionSemillero observacionSemillero) {
        observacionSemilleroRepository.save(observacionSemilleroMapper.obtenerEntity(observacionSemillero));
        return true;
    }
}
