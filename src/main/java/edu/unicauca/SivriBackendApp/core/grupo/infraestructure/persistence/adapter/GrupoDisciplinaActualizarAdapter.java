package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoDisciplina;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.GrupoDisciplinaActualizarREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.GrupoDisciplinaMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IGrupoDisciplinaRepository;
import org.springframework.stereotype.Component;

@Component
public class GrupoDisciplinaActualizarAdapter implements GrupoDisciplinaActualizarREPO {
    private final IGrupoDisciplinaRepository grupoDisciplinaRepository;
    private final GrupoDisciplinaMapper grupoDisciplinaMapper;

    public GrupoDisciplinaActualizarAdapter(IGrupoDisciplinaRepository grupoDisciplinaRepository, GrupoDisciplinaMapper grupoDisciplinaMapper) {
        this.grupoDisciplinaRepository = grupoDisciplinaRepository;
        this.grupoDisciplinaMapper = grupoDisciplinaMapper;
    }

    @Override
    public Boolean actualizar(GrupoDisciplina nuevoDatos) {
        grupoDisciplinaRepository.save(grupoDisciplinaMapper.obtenerEntity(nuevoDatos));
        return true;
    }
}
