package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.RolSemilleroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolSemilleroRepository extends JpaRepository<RolSemilleroEntity,Integer> {
}
