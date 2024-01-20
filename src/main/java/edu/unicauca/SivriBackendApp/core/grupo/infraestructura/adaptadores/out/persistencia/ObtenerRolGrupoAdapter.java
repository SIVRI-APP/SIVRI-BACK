package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.RolesGrupoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.RolGrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.RolGrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IRolGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ObtenerRolGrupoAdapter implements RolesGrupoObtenerREPO {

    private final IRolGrupoRepository rolGrupoRepository;

    private final RolGrupoMapper rolGrupoMapper;

    public ObtenerRolGrupoAdapter(IRolGrupoRepository rolGrupoRepository, RolGrupoMapper rolGrupoMapper) {
        this.rolGrupoRepository = rolGrupoRepository;
        this.rolGrupoMapper = rolGrupoMapper;
    }

    @Override
    public Optional<RolGrupo> obtenerRolGrupoPorId(int id) {

        Optional<RolGrupoEntity> respuetaJpa= rolGrupoRepository.findById(id);
        if (respuetaJpa.isPresent()) {
            return Optional.of(rolGrupoMapper.obtenerModelo(respuetaJpa.get()));
        }

        return Optional.empty();
         }

    @Override
    public Boolean existePorId(int id) {
        return rolGrupoRepository.existsById(id);
    }

    @Override
    public List<RolGrupo> obtenerRolesGrupo() {

        return this.rolGrupoRepository.findAll().stream().map(rolGrupoEntity ->
        {
            RolGrupo rolGrupo=rolGrupoMapper.obtenerModelo(rolGrupoEntity);
            return rolGrupo;
        }).collect(Collectors.toList());
    }
}
