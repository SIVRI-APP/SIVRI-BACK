package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.IntegranteSemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper.IntegranteSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.IntegranteSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository.IIntegranteSemilleroRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IntegranteSemilleroActualizarAdapter implements IntegranteSemilleroActualizarREPO {
    private final IIntegranteSemilleroRepository integranteSemilleroRepository;
    private final IntegranteSemilleroMapper integranteSemilleroMapper;

    public IntegranteSemilleroActualizarAdapter(IIntegranteSemilleroRepository integranteSemilleroRepository, IntegranteSemilleroMapper integranteSemilleroMapper) {
        this.integranteSemilleroRepository = integranteSemilleroRepository;
        this.integranteSemilleroMapper = integranteSemilleroMapper;
    }

    @Override
    public Boolean actualizar(IntegranteSemillero nuevosDatosIntegrante) {
        //System.out.println("DATOS QUE INGRESAN AL ADAPTER DEL INTEGRANTE A ACTUALIZAR "+nuevosDatosIntegrante);
        IntegranteSemilleroEntity integrante= integranteSemilleroRepository.save(integranteSemilleroMapper.obtenerEntity(nuevosDatosIntegrante));
        //System.out.println("INTEGRANTE SEMILLERO ENTITY "+integrante);
        return true;
    }
}
