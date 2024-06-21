package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoDisciplinaCrearREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.GrupoDisciplinaMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IGrupoDisciplinaRepository;
import org.springframework.stereotype.Component;

@Component
public class GrupoDisciplinaCrearAdapter implements GrupoDisciplinaCrearREPO {
    private final IGrupoDisciplinaRepository grupoDisciplinaRepository;
    private final GrupoDisciplinaMapper grupoDisciplinaMapper;

    public GrupoDisciplinaCrearAdapter(IGrupoDisciplinaRepository grupoDisciplinaRepository, GrupoDisciplinaMapper grupoDisciplinaMapper) {
        this.grupoDisciplinaRepository = grupoDisciplinaRepository;
        this.grupoDisciplinaMapper = grupoDisciplinaMapper;
    }
    @Override
    public Boolean crear(GrupoDisciplina nuevosDatos) {
        grupoDisciplinaRepository.save(grupoDisciplinaMapper.obtenerEntity(nuevosDatos));
        return true;
    }
}
