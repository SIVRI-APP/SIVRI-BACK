package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.SemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.IntegranteSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.SemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IIntegranteSemilleroRepository;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.ISemilleroRepository;
import org.springframework.stereotype.Component;

@Component
public class SemilleroCrearAdapter implements SemilleroCrearREPO {
    private final ISemilleroRepository semilleroRepository;
    private final IIntegranteSemilleroRepository integranteSemilleroRepository;
    private final SemilleroMapper semilleroMapper;
    private final IntegranteSemilleroMapper integranteSemilleroMapper;

    public SemilleroCrearAdapter(ISemilleroRepository semilleroRepository, IIntegranteSemilleroRepository integranteSemilleroRepository, SemilleroMapper semilleroMapper, IntegranteSemilleroMapper integranteSemilleroMapper) {
        this.semilleroRepository = semilleroRepository;
        this.integranteSemilleroRepository = integranteSemilleroRepository;
        this.semilleroMapper = semilleroMapper;
        this.integranteSemilleroMapper = integranteSemilleroMapper;
    }

    @Override
    public Semillero crear(Semillero nuevoSemillero) {

        Semillero semillero=semilleroMapper.obtenerModelo(semilleroRepository.save(semilleroMapper.obtenerEntity(nuevoSemillero)));

        return semillero ;
    }


}
