package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.RolGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolGrupoRepository extends JpaRepository<RolGrupoEntity, Integer> {

}
