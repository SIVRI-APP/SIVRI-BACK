package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.IntegranteSemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.IntegranteSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.IntegranteSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IIntegranteSemilleroRepository;
import org.springframework.stereotype.Component;

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
        integranteSemilleroRepository.save(integranteSemilleroMapper.obtenerEntity(nuevosDatosIntegrante));
        return true;
    }
}
