package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.IntegranteSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.SemilleroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IIntegranteSemilleroRepository extends JpaRepository<IntegranteSemilleroEntity,Integer> {
    //public List<SemilleroEntity> findByusuarioNumeroDocumento(String idMentor);

}
