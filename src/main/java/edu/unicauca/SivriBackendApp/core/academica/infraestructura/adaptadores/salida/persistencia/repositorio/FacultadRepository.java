package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.repositorio;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.entidad.FacultadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultadRepository extends JpaRepository<FacultadEntity,Integer> {
}
