package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.RolGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolGrupoRepository extends JpaRepository<RolGrupoEntity, Integer> {

}
