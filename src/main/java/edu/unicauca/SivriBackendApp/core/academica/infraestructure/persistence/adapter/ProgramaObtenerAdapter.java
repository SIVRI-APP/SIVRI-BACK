package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.Programa;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.out.ProgramaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.mapper.ProgramaMapper;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaRepository.IProgramaRepository;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.ConvocatoriaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProgramaObtenerAdapter implements ProgramaObtenerREPO {
    private final IProgramaRepository programaRepository;
    private final ProgramaMapper programaMapper;

    public ProgramaObtenerAdapter(IProgramaRepository programaRepository, ProgramaMapper programaMapper) {
        this.programaRepository = programaRepository;
        this.programaMapper = programaMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return programaRepository.existsById(id);
    }

    @Override
    public Optional<Programa> obtenerPorId(int id) {
        Optional<ProgramaEntity> respuestaJpa =programaRepository.findById(id);
        return respuestaJpa.map(programaMapper::obtenerModelo);
    }

    @Override
    public List<Programa> listarProgramasPorSemillero(int idSemillero) {

        return null;
    }

    @Override
    public List<Programa> obtenerProgramas() {
        return programaRepository.findAll().stream().map(programaMapper::obtenerModelo).collect(Collectors.toList());
    }
}
