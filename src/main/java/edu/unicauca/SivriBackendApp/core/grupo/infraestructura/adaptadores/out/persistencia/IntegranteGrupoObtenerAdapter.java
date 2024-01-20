package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.IntegranteGrupoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.IntegranteGrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.IntegranteGrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IIntegranteGrupoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class IntegranteGrupoObtenerAdapter implements IntegranteGrupoObtenerREPO {

    private final IIntegranteGrupoRepository integranteGrupoRepository;

    private final IntegranteGrupoMapper integranteGrupoMapper;

    public IntegranteGrupoObtenerAdapter(IIntegranteGrupoRepository integranteGrupoRepository, IntegranteGrupoMapper integranteGrupoMapper) {
        this.integranteGrupoRepository = integranteGrupoRepository;
        this.integranteGrupoMapper = integranteGrupoMapper;
    }


    @Override
    public Optional<IntegranteGrupo> obtenerIntegranteGrupoPorId(int id) {
        Optional<IntegranteGrupoEntity> respuestaJpa = integranteGrupoRepository.findById(id);
        Optional<IntegranteGrupo> modeloIntegranteGrupo= respuestaJpa.map(integranteGrupoMapper::obtenerModelo);
        //System.out.println("MODELO integrante grupo "+modeloIntegranteGrupo);
        return modeloIntegranteGrupo;
    }

    @Override
    public List<IntegranteGrupo> obtenerIntegrantesGrupo() {
        return integranteGrupoRepository.findAll().stream().map(integranteGrupoMapper::obtenerModelo).collect(Collectors.toList());
    }
}
