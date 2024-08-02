package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.IntegranteGrupoCrearREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.IntegranteGrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.IntegranteGrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IIntegranteGrupoRepository;
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
         IntegranteGrupoEntity objInteegrante=integranteGrupoRepository.save(integranteGrupoMapper.obtenerEntity(nuevosDatos));
         return true;
    }
}
