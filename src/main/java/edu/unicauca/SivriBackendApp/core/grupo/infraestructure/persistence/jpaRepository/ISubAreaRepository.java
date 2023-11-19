package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.SubAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubAreaRepository extends JpaRepository<SubAreaEntity,Integer> {

}
