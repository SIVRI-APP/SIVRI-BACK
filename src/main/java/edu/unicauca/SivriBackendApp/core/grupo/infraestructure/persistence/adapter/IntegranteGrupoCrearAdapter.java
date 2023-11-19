package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.IntegranteGrupoCrearREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.IntegranteGrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.IntegranteGrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IIntegranteGrupoRepository;
import org.springframework.stereotype.Component;

@Component
public class IntegranteGrupoCrearAdapter implements IntegranteGrupoCrearREPO {
    private final IIntegranteGrupoRepository integranteGrupoRepository;
    private final IntegranteGrupoMapper integranteGrupoMapper;

    public IntegranteGrupoCrearAdapter(IIntegranteGrupoRepository integranteGrupoRepository, IntegranteGrupoMapper integranteGrupoMapper) {
        this.integranteGrupoRepository = integranteGrupoRepository;
        this.integranteGrupoMapper = integranteGrupoMapper;
    }

    @Override
    public Boolean asociarIntegranteGrupo(IntegranteGrupo nuevosDatos) {
        //System.out.println("DATOS QUE LLEGAN AL ADAPTER: "+nuevosDatos);
        IntegranteGrupoEntity objInteegrante=integranteGrupoRepository.save(integranteGrupoMapper.obtenerEntity(nuevosDatos));
        //System.out.println("OBJ INTEGRANTE nuevo "+objInteegrante);
        return true;
    }
}
