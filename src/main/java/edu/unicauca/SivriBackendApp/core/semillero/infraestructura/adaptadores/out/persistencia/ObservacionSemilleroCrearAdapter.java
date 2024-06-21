package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.ObservacionSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.ObservacionSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.ObservacionSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IObservacionSemilleroRepository;
import org.springframework.stereotype.Component;

@Component
public class ObservacionSemilleroCrearAdapter implements ObservacionSemilleroCrearREPO {

    private final IObservacionSemilleroRepository observacionSemilleroRepository;

    private final ObservacionSemilleroMapper observacionSemilleroMapper;

    public ObservacionSemilleroCrearAdapter(IObservacionSemilleroRepository observacionSemilleroRepository, ObservacionSemilleroMapper observacionSemilleroMapper) {
        this.observacionSemilleroRepository = observacionSemilleroRepository;
        this.observacionSemilleroMapper = observacionSemilleroMapper;
    }

    @Override
    public Boolean crear(ObservacionSemillero nuevaObservacion) {

        observacionSemilleroRepository.save(observacionSemilleroMapper.obtenerEntity(nuevaObservacion));
        return true;
    }

}
