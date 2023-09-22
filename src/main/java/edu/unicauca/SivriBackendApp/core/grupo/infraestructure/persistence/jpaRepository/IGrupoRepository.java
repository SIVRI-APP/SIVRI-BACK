package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrupoRepository extends JpaRepository<GrupoEntity,Integer> {
}
