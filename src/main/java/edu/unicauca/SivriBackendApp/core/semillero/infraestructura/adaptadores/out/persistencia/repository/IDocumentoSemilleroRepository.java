package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.DocumentoSemilleroProyeccion;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.VerDoumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.DocumentoSemilleroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IDocumentoSemilleroRepository extends JpaRepository<DocumentoSemilleroEntity, Integer> {
   // public Optional<DocumentoSemillero> findByFechaRegistroAndTipo(LocalDate fechaRegistro, TipoDocumentoSemillero tipo);
 //query ok
 @Query(value = "SELECT COALESCE ((SELECT ds.ID FROM documento_semillero ds WHERE ds.semillero_Id =:idSemillero AND ds.tipo =:tipo " +
            "            ORDER BY ds.fecha_Registro DESC FETCH FIRST 1 ROWS ONLY),0) as id FROM dual",nativeQuery = true)
    public Integer existeDocumentoxIdSemillero(@Param("idSemillero") Integer idSemillero,@Param("tipo") String tipo);
    @Query(value = "SELECT * FROM documento_semillero ds WHERE ds.semilleroId =:idSemillero AND ds.tipo =:tipo and ds.documentoActivo='1' ORDER by abs(DATEDIFF(NOW(), ds.fechaRegistro));",nativeQuery = true)
    public Optional<DocumentoSemilleroEntity> obtenerIdDocumento(@Param("idSemillero") Integer idSemillero,@Param("tipo") String tipo);
    @Query(value = "SELECT * FROM documento_semillero ds " +
            "WHERE ds.semillero_Id =:idSemillero " +
            "AND ds.tipo =:tipo AND ds.documento_Activo='1' " +
            "ORDER by ds.fecha_Registro DESC",nativeQuery = true)
    public Optional<DocumentoSemilleroProyeccion> obtenerDocumentoxDocumentoActivo(@Param("idSemillero") Integer idSemillero,@Param("tipo") String tipo);
    DocumentoSemilleroEntity findBySemilleroAndFechaRegistroAndTipo(Semillero semillero, LocalDate fechaRegistro, TipoDocumentoSemillero tipo);
    Boolean existsBySemilleroIdAndTipo(Integer semilleroId, TipoDocumentoSemillero tipo);

}
