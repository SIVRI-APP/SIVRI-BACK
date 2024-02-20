package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAreaRepository extends JpaRepository<AreaEntity,Integer> {


 }
