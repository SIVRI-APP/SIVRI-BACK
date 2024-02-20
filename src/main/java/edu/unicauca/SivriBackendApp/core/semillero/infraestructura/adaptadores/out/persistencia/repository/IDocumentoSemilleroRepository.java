package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.VerDoumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.DocumentoSemilleroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDocumentoSemilleroRepository extends JpaRepository<DocumentoSemilleroEntity, Integer> {
//    @Query(value = "",nativeQuery = true)
//    Optional<VerDoumentoSemillero> verDocumentoSemillero();
}
