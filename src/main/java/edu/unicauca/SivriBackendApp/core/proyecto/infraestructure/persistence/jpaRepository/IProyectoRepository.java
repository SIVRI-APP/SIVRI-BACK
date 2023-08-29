package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.ProyectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<ProyectoEntity, Integer>{
}
