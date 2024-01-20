package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoDisciplinaActualizarREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.GrupoDisciplinaMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IGrupoDisciplinaRepository;
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
