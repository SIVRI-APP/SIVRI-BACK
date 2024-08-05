package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.VerDoumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.DocumentoSemilleroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDocumentoSemilleroRepository extends JpaRepository<DocumentoSemilleroEntity, Integer> {
    @Query(value = "SELECT COALESCE ((SELECT ds.id FROM documento_semillero ds WHERE ds.semilleroId =:idSemillero AND ds.tipo =:tipo " +
            "ORDER BY ABS(DATEDIFF(NOW(), ds.fechaRegistro)) " +
            "LIMIT 1),0) as id;",nativeQuery = true)
    public Integer existeDocumentoxIdSemillero(@Param("idSemillero") Integer idSemillero,@Param("tipo") String tipo);

}
