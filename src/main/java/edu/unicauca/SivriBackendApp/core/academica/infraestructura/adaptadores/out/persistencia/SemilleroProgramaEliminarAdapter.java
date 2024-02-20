package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.out.SemilleroProgramaEliminarREPO;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.repository.ISemilleroProgramaRepository;
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
