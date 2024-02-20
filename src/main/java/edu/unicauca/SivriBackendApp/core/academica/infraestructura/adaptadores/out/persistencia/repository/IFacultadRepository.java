package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.FacultadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacultadRepository extends JpaRepository<FacultadEntity,Integer> {
}
