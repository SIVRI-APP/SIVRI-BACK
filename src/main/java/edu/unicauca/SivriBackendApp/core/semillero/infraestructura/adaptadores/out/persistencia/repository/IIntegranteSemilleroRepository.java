package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroIntegrantesSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarIntegrantesSemilleroxIdSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarTodosIntegrantesConFiltro;
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

    @Query(value = "SELECT  " +
            "    u.numeroDocumento, " +
            "    CONCAT(u.nombre, ' ', u.apellido) AS nombres, " +
            "    s.semilleroId, " +
            "    odi.nombre AS nombreSemillero, " +
            "    rs.rolSemillero, " +
            "    is2.estado, " +
            "    u.programaId " +
            "FROM " +
            "    integrante_semillero AS is2 " +
            "    INNER JOIN rol_semillero AS rs ON rs.id = is2.rolId " +
            "    INNER JOIN semillero AS s ON s.semilleroId = is2.semilleroId " +
            "    INNER JOIN organismo_de_investigacion AS odi ON odi.id = s.semilleroId " +
            "    INNER JOIN usuario AS u ON u.id = is2.usuarioId " +
            "WHERE " +
            "    (LOWER(u.numeroDocumento) LIKE CONCAT('%', LOWER(:numeroDocumento), '%') OR :numeroDocumento IS NULL OR :numeroDocumento = '') " +
            "    AND (LOWER(CONCAT(u.nombre, ' ', u.apellido)) LIKE CONCAT('%', LOWER(:nombres), '%') OR :nombres IS NULL OR :nombres = '') " +
            "    AND (s.semilleroId LIKE CONCAT('%', :semilleroId, '%') OR :semilleroId IS NULL OR :semilleroId = '') " +
            "    AND (LOWER(odi.nombre) LIKE CONCAT('%', LOWER(:nombreSemillero), '%') OR :nombreSemillero IS NULL OR :nombreSemillero = '') " +
            "    AND (LOWER(rs.rolSemillero) = LOWER(:rolSemillero) OR :rolSemillero IS NULL OR :rolSemillero = '') " +
            "    AND (LOWER(is2.estado) = LOWER(:estado) OR :estado IS NULL OR :estado = '');",nativeQuery = true)
    Page<List<ListarTodosIntegrantesConFiltro>> listarTodosIntegranteSemilleroConFiltro(
            @Param("numeroDocumento") String numeroDocumento,
            @Param("nombres") String nombres,
            @Param("semilleroId") Integer semilleroId,
            @Param("nombreSemillero") String nombreSemillero,
            @Param("rolSemillero") String rolSemillero,
            @Param("estado") String estado,
            /*@Param("nombrePrograma") String nombrePrograma,*/
            /*@Param("facultad") String facultad*/
            @PageableDefault(size = 10,page = 0,sort = "id") Pageable pageable);

}
