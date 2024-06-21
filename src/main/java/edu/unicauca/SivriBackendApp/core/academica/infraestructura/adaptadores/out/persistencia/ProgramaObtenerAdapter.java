package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.out.ProgramaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.Programa;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.mapper.ProgramaMapper;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.repository.ProgramaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProgramaObtenerAdapter implements ProgramaObtenerREPO {
    private final ProgramaRepository programaRepository;
    private final ProgramaMapper programaMapper;


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
