package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.out.SemilleroProgramaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.mapper.SemilleroProgramaMapper;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.SemilleroProgramaEntity;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaRepository.ISemilleroProgramaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SemilleroProgramaObtenerAdapter implements SemilleroProgramaObtenerREPO {
    private final ISemilleroProgramaRepository semilleroProgramaRepository;
    private final SemilleroProgramaMapper semilleroProgramaMapper;

    public SemilleroProgramaObtenerAdapter(ISemilleroProgramaRepository semilleroProgramaRepository, SemilleroProgramaMapper semilleroProgramaMapper) {
        this.semilleroProgramaRepository = semilleroProgramaRepository;
        this.semilleroProgramaMapper = semilleroProgramaMapper;
    }

    @Override
    public Boolean existePorId(long id) {
        return semilleroProgramaRepository.existsById(id);
    }

    @Override
    public Optional<SemilleroPrograma> obtenerPorId(long id) {
        Optional<SemilleroProgramaEntity> respuestaJpa =semilleroProgramaRepository.findById(id);
        return respuestaJpa.map(semilleroProgramaMapper::obtenerModelo);
    }

    @Override
    public List<SemilleroPrograma> obtenerListadoProgramasPorSemilleroId(int idSemillero) {
        return semilleroProgramaRepository.findBySemilleroId(idSemillero).stream().map(semilleroProgramaMapper::obtenerModelo).collect(Collectors.toList());
    }

}
