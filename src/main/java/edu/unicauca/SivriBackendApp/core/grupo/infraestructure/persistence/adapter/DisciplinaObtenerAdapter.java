package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.DisciplinaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.DisciplinaMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.DisciplinaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IDisciplinaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DisciplinaObtenerAdapter implements DisciplinaObtenerREPO {
    private final IDisciplinaRepository disciplinaRepository;
    private final DisciplinaMapper disciplinaMapper;

    public DisciplinaObtenerAdapter(IDisciplinaRepository disciplinaRepository, DisciplinaMapper disciplinaMapper) {
        this.disciplinaRepository = disciplinaRepository;
        this.disciplinaMapper = disciplinaMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return disciplinaRepository.existsById(id);
    }

    @Override
    public Optional<Disciplina> obtenerPorId(int id) {
        Optional<DisciplinaEntity> respuestaJpa =disciplinaRepository.findById(id);
        return respuestaJpa.map(disciplinaMapper::obtenerModeloUno);
    }
}
