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
   @Query(value = "select u.numeroDocumento,concat(u.nombres,' ',u.apellidos) as nombreCompleto,rs.rolSemillero,ins.estado, ins.fechaIngreso,ins.fechaRetiro " +
           "from integrante_semillero ins " +
           "inner join usuario u on u.id=ins.usuarioId " +
           "inner join rol_semillero rs on rs.id=ins.rolId " +
           "where ins.semilleroId=(:semilleroId);",nativeQuery = true)
   Page<List<ListarIntegrantesSemilleroxIdSemillero>> obtenerIntegrantesSemilleroPorIdSemillero(
           @Param("semilleroId") int semilleroId,
           @PageableDefault(size = 10,page = 0,sort = "id") Pageable pageable);
    // TODO falta agregar el programa no esta en usuario y buscar por programa tambien
    @Query(value = "SELECT u.numeroDocumento,u.nombres,u.apellidos,rs.rolSemillero,intse.estado, intse.fechaIngreso,intse.fechaRetiro " +
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
