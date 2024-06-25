package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroIntegrantesSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarIntegrantesSemilleroxIdSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.IntegranteSemilleroEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface IIntegranteSemilleroRepository extends JpaRepository<IntegranteSemilleroEntity,Integer> {
    //public List<SemilleroEntity> findByusuarioId(String idMentor);
   public List<IntegranteSemilleroEntity> findBySemilleroId(int idSemillero);
   //TODO falta el programa que no sta includo en el usuario
   @Query(value = "SELECT ins.idIntegranteSemillero,\n" +
           "       u.numeroDocumento,\n" +
           "       CONCAT(u.nombre, ' ', u.apellido) AS nombreCompleto,\n" +
           "       rs.rolSemillero,\n" +
           "       ins.estado,\n" +
           "       ins.fechaIngreso\n" +
           "FROM integrante_semillero ins\n" +
           "INNER JOIN usuario u ON u.id = ins.usuarioId\n" +
           "INNER JOIN rol_semillero rs ON rs.id = ins.rolId\n" +
           "WHERE ins.semilleroId = (:semilleroId)\n" +
           "AND (LOWER(u.numeroDocumento) LIKE COALESCE(CONCAT('%', LOWER(:numeroDocumento), '%'), '%') OR :numeroDocumento IS NULL OR :numeroDocumento = '')\n" +
           "AND (LOWER(rs.rolSemillero) LIKE COALESCE(LOWER(:rolSemillero), '%') OR :rolSemillero IS NULL OR :rolSemillero = '')\n" +
           "AND (LOWER(ins.estado) LIKE COALESCE(LOWER(:estado), '%') OR :estado IS NULL OR :estado = '');",nativeQuery = true)
   Page<List<ListarIntegrantesSemilleroxIdSemillero>> obtenerIntegrantesSemilleroPorIdSemillero(
           @Param("semilleroId") int semilleroId,
           @Param("numeroDocumento") String numeroDocumento,
           @Param("rolSemillero") String rolSemillero,
           @Param("estado") String estado,
           @PageableDefault(size = 10,page = 0,sort = "id") Pageable pageable);
    // TODO falta agregar el programa no esta en usuario y buscar por programa tambien
    @Query(value = "SELECT u.numeroDocumento,u.nombre,u.apellido,rs.rolSemillero,intse.estado, intse.fechaIngreso,intse.fechaRetiro " +
            "FROM integrante_semillero intse  " +
            "    INNER JOIN usuario u ON intse.usuarioId=u.id " +
            "    INNER JOIN rol_semillero rs ON rs.id=intse.rolId " +
            "    WHERE " +
            "       (LOWER(u.numeroDocumento) = COALESCE(LOWER(:numeroDocumento),LOWER(u.numeroDocumento)) OR :numeroDocumento is null) " +
            "        AND (LOWER(rs.rolSemillero) = COALESCE(LOWER(:rolSemillero),LOWER(rs.rolSemillero)) OR :rolSemillero is null) " +
            "        AND (LOWER(intse.estado) = COALESCE(LOWER(:estado),LOWER(intse.estado)) OR :estado IS NULL);",nativeQuery = true)
    Page<List<ListarConFiltroIntegrantesSemillero>> listarIntegranteSemilleroConFiltro(
            @Param("numeroDocumento") String numeroDocumento,
            @Param("rolSemillero") String rolSemillero,
            @Param("estado") String estado,
            /*@Param("nombrePrograma") String nombrePrograma,*/
            @PageableDefault(size = 10,page = 0,sort = "id") Pageable pageable);

}
