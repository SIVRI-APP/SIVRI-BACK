package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.SubAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubAreaRepository extends JpaRepository<SubAreaEntity,Integer> {

}
