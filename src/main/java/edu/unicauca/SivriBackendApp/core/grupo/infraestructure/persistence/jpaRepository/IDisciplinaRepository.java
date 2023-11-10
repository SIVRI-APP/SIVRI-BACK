package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDisciplinaRepository extends JpaRepository<DisciplinaEntity,Integer> {
}
