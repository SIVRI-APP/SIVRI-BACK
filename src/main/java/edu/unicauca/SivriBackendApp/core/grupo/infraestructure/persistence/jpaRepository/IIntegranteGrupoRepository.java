package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.IntegranteGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIntegranteGrupoRepository extends JpaRepository<IntegranteGrupoEntity,Integer> {
}
