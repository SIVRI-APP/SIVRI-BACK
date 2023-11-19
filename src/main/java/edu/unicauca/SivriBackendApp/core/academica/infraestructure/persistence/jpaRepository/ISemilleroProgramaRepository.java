package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.SemilleroProgramaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISemilleroProgramaRepository extends JpaRepository<SemilleroProgramaEntity,Long> {
    public List<SemilleroProgramaEntity> findBySemilleroId(int semilleroId);

}
