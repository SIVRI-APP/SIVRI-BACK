package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.out.SemilleroProgramaActualizarREPO;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.mapper.SemilleroProgramaMapper;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaRepository.ISemilleroProgramaRepository;
import org.springframework.stereotype.Component;

@Component
public class SemilleroProgramaActualizarAdapter implements SemilleroProgramaActualizarREPO {
    private final ISemilleroProgramaRepository semilleroProgramaRepository;
    private final SemilleroProgramaMapper semilleroProgramaMapper;

    public SemilleroProgramaActualizarAdapter(ISemilleroProgramaRepository semilleroProgramaRepository, SemilleroProgramaMapper semilleroProgramaMapper) {
        this.semilleroProgramaRepository = semilleroProgramaRepository;
        this.semilleroProgramaMapper = semilleroProgramaMapper;
    }

    @Override
    public Boolean actualizar(SemilleroPrograma nuevosDatos) {
        semilleroProgramaRepository.save(semilleroProgramaMapper.obtenerEntity(nuevosDatos));
        return true;
    }
}
