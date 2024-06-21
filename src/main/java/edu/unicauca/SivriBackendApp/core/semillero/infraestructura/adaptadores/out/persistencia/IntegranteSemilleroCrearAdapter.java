package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.IntegranteSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.IntegranteSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.SemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IIntegranteSemilleroRepository;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.ISemilleroRepository;
import org.springframework.stereotype.Component;

@Component
public class IntegranteSemilleroCrearAdapter implements IntegranteSemilleroCrearREPO {
    private final IIntegranteSemilleroRepository integranteSemilleroRepository;
    private final IntegranteSemilleroMapper integranteSemilleroMapper;
    private final ISemilleroRepository semilleroRepository;
    private final SemilleroMapper semilleroMapper;

    public IntegranteSemilleroCrearAdapter(IIntegranteSemilleroRepository integranteSemilleroRepository, IntegranteSemilleroMapper integranteSemilleroMapper, ISemilleroRepository semilleroRepository, SemilleroMapper semilleroMapper) {
        this.integranteSemilleroRepository = integranteSemilleroRepository;
        this.integranteSemilleroMapper = integranteSemilleroMapper;


        this.semilleroRepository = semilleroRepository;
        this.semilleroMapper = semilleroMapper;
    }

    @Override
    public Boolean crear(IntegranteSemillero nuevoIntegranteSemillero) {
        System.out.println("integrante semillero adapter "+nuevoIntegranteSemillero);
        integranteSemilleroRepository.save(integranteSemilleroMapper.obtenerEntity(nuevoIntegranteSemillero));
        return true;
    }
}
