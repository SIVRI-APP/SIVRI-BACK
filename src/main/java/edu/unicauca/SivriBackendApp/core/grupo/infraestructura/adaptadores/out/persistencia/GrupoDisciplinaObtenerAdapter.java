package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoDisciplinaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoDisciplinaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.GrupoDisciplinaMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IGrupoDisciplinaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GrupoDisciplinaObtenerAdapter implements GrupoDisciplinaObtenerREPO {
    private final IGrupoDisciplinaRepository grupoDisciplinaRepository;
    private final GrupoDisciplinaMapper grupoDisciplinaMapper;

    public GrupoDisciplinaObtenerAdapter(IGrupoDisciplinaRepository grupoDisciplinaRepository, GrupoDisciplinaMapper grupoDisciplinaMapper) {
        this.grupoDisciplinaRepository = grupoDisciplinaRepository;
        this.grupoDisciplinaMapper = grupoDisciplinaMapper;
    }

    @Override
    public Boolean existePorId(long id) {
        return grupoDisciplinaRepository.existsById(id);
    }

    @Override
    public Optional<GrupoDisciplina> obtenerPorId(long id) {
        Optional<GrupoDisciplinaEntity> respuestaJpa =grupoDisciplinaRepository.findById(id);
        return respuestaJpa.map(grupoDisciplinaMapper::obtenerModelo);
    }

    @Override
    public List<GrupoDisciplina> obtenerListadoDisciplinasPorGrupoId(int idGrupo) {
        return grupoDisciplinaRepository.findByGrupoId(idGrupo).stream().map(grupoDisciplinaMapper::obtenerModelo).collect(Collectors.toList());
    }
}
