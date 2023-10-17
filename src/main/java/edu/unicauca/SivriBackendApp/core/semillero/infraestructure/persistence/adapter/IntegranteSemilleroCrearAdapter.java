package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.IntegranteSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper.IntegranteSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.IntegranteSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository.IIntegranteSemilleroRepository;
import org.springframework.stereotype.Component;

@Component
public class IntegranteSemilleroCrearAdapter implements IntegranteSemilleroCrearREPO {
    private final IIntegranteSemilleroRepository integranteSemilleroRepository;
    private final IntegranteSemilleroMapper integranteSemilleroMapper;

    public IntegranteSemilleroCrearAdapter(IIntegranteSemilleroRepository integranteSemilleroRepository, IntegranteSemilleroMapper integranteSemilleroMapper) {
        this.integranteSemilleroRepository = integranteSemilleroRepository;
        this.integranteSemilleroMapper = integranteSemilleroMapper;
    }

    @Override
    public Boolean crear(IntegranteSemillero nuevoIntegranteSemillero) {
        System.out.println("DATOS QUE LLEGAN AL ADAPTER DE INTEGRANTE "+nuevoIntegranteSemillero);
        IntegranteSemilleroEntity integrante =integranteSemilleroRepository.save(integranteSemilleroMapper.obtenerEntity(nuevoIntegranteSemillero));
        System.out.println("INTEGRANTE "+integrante);
        return true;
    }
}
