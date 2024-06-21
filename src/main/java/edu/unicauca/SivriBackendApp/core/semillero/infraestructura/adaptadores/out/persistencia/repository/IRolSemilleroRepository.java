package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.RolSemilleroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolSemilleroRepository extends JpaRepository<RolSemilleroEntity,Integer> {
}
