package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.GrupoDisciplinaEliminarREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.GrupoDisciplinaMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IGrupoDisciplinaRepository;
import org.springframework.stereotype.Component;

@Component
public class GrupoDisciplinaEliminarAdapter implements GrupoDisciplinaEliminarREPO {
    private final IGrupoDisciplinaRepository grupoDisciplinaRepository;
    public GrupoDisciplinaEliminarAdapter(IGrupoDisciplinaRepository grupoDisciplinaRepository) {
        this.grupoDisciplinaRepository = grupoDisciplinaRepository;
    }

    @Override
    public Boolean eliminacionGrupoDisciplinaFisico(long id) {
        grupoDisciplinaRepository.deleteById(id);
        return true;
    }
}
