package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.RolesGrupoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.RolGrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.RolGrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IRolGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ObtenerRolGrupoAdapter implements RolesGrupoObtenerREPO {
    @Autowired
    IRolGrupoRepository rolGrupoRepository;
    @Autowired
    RolGrupoMapper rolGrupoMapper;


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
