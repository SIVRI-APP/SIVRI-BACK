package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.academica.domain.port.out.SemilleroProgramaEliminarREPO;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.mapper.SemilleroProgramaMapper;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaRepository.ISemilleroProgramaRepository;
import org.springframework.stereotype.Component;

@Component
public class SemilleroProgramaEliminarAdapter implements SemilleroProgramaEliminarREPO {
    private final ISemilleroProgramaRepository semilleroProgramaRepository;


    public SemilleroProgramaEliminarAdapter(ISemilleroProgramaRepository semilleroProgramaRepository) {
        this.semilleroProgramaRepository = semilleroProgramaRepository;

    }

    @Override
    public Boolean eliminadoFisicoSemilleroPrograma(long id) {
        semilleroProgramaRepository.deleteById(id);
        return true;
    }
}
