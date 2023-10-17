package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.IntegranteGrupoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.IntegranteGrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.IntegranteGrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IIntegranteGrupoRepository;
import org.springframework.stereotype.Component;

@Component
public class IntegranteGrupoAcualizarAdapter implements IntegranteGrupoActualizarREPO {
    private final IIntegranteGrupoRepository integranteGrupoRepository;
    private final IntegranteGrupoMapper integranteGrupoMapper;

    public IntegranteGrupoAcualizarAdapter(IIntegranteGrupoRepository integranteGrupoRepository, IntegranteGrupoMapper integranteGrupoMapper) {
        this.integranteGrupoRepository = integranteGrupoRepository;
        this.integranteGrupoMapper = integranteGrupoMapper;
    }

    @Override
    public Boolean actualizar(IntegranteGrupo nuevosDatos) {
        //System.out.println("DATOS QUE LLEGAN AL ADAPTER: "+nuevosDatos);
        IntegranteGrupoEntity integranteGrupo=integranteGrupoRepository.save(integranteGrupoMapper.obtenerEntity(nuevosDatos));
        //System.out.println("INTERGANTE GRUPO DESPUES DEL MAPEO: "+integranteGrupo);
        return true;
    }
}
