package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroSemilleros;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarSemilleroPorIdMentor;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarSemillerosConFiltroxMentor;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.SemilleroEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISemilleroRepository extends JpaRepository<SemilleroEntity, Integer> {
    //@Query("SELECT s FROM Semillero s WHERE s.idSemillero = ?1 OR s.nombreSemillero = ?2")
    public List<SemilleroEntity> findByIdAndNombreLikeIgnoreCase(int idSemillero, String nombre);
    public List<SemilleroEntity> findByNombreLikeIgnoreCase(String nombre);
    //public List<SemilleroEntity> findByNombre( String nombre);
    public Boolean existsByNombre(String nombre);

    public List<SemilleroEntity> findByGrupoId(int idGrupo);
    @Query(value = "select s.*,oi.* from integrante_grupo ig " +
            "inner join grupo g on ig.grupoId=g.grupoId " +
            "inner join semillero s on s.grupoId=g.grupoId " +
            "inner join organismo_de_investigacion oi on oi.id=s.semilleroId " +
            "where usuarioId=(:idDirectorGrupo) and rolGrupoId=1;", nativeQuery = true)
    public List<SemilleroEntity> listarxIdDirectorGrupo(long idDirectorGrupo);


    @Query(value = "select\n" +
            "\ts.semilleroId,\n" +
            "\toi.nombre,\n" +
            "\ts.correo,\n" +
            "\toi.fechaCreacion,\n" +
            "\ts.estado\n" +
            "from\n" +
            "\tsemillero s\n" +
            "left join organismo_de_investigacion oi on s.semilleroId = oi.id\n" +
            "where\n" +
            "\t(:nombre is null or LOWER(oi.nombre) like lower(CONCAT('%', :nombre, '%'))) and\n" +
            "\t(:correo is null or LOWER(s.correo) like lower(CONCAT('%', :correo, '%'))) and\n" +
            "\t(:estado is null or LOWER(s.estado) like lower(CONCAT('%', :estado, '%')));",nativeQuery = true)
    /*@Query(value = "SELECT s.semilleroId, oi.nombre, s.correo, oi.fechaCreacion, s.estado \n" +
            "FROM semillero s \n" +
            "LEFT JOIN organismo_de_investigacion oi ON s.semilleroId = oi.id \n" +
            "WHERE \n" +
            "    (LOWER(oi.nombre) LIKE '%' || LOWER(:nombre) || '%' OR LOWER(oi.nombre) = COALESCE(LOWER(:nombre), LOWER(oi.nombre)) OR :nombre IS NULL OR :nombre = '')\n" +
            "    AND (LOWER(s.correo) LIKE '%' || LOWER(:correo) || '%' OR LOWER(s.correo) = COALESCE(LOWER(:correo), LOWER(s.correo)) OR :correo IS NULL OR :correo = '')\n" +
            "    AND (LOWER(s.estado) = COALESCE(LOWER(:estado), LOWER(s.estado)) OR :estado IS NULL);",nativeQuery = true)*/
    Page<List<ListarConFiltroSemilleros>> listarSemillerosConFiltro(
            @Param("nombre") String nombre,
            @Param("correo") String correo,
            @Param("estado") String estado,
            @PageableDefault(size = 10,page = 0,sort = "id")Pageable pageable);
    // CONSULTA LOS SEMILLEROS DE UN MENTOR
    @Query(value = "SELECT s.semilleroId,oi.nombre,s.estado " +
            "            FROM semillero s left JOIN organismo_de_investigacion oi " +
            "            ON s.semilleroId=oi.id " +
            "            inner join integrante_semillero ins on ins.semilleroId=s.semilleroId " +
            "            WHERE " +
            "               (LOWER(oi.nombre) LIKE %:nombre% OR LOWER(oi.nombre) = COALESCE(LOWER(:nombre),LOWER(oi.nombre) ) OR :nombre IS NULL) " +
            "               AND (LOWER(s.estado) = COALESCE(LOWER(:estado),LOWER(s.estado)) OR :estado IS NULL) " +
            "               AND ((s.semilleroId) like (:semilleroId) or (s.semilleroId)= coalesce((:semilleroId),(s.semilleroId)) or (:semilleroId) IS NULL) " +
            "               AND ins.usuarioId = (:usuarioId) and ins.rolId=2;",nativeQuery = true)
    Page<List<ListarSemillerosConFiltroxMentor>> listarSemillerosConFiltroxMentor(
            @Param("semilleroId") Integer semilleroId,
            @Param("usuarioId") Long usuarioId,
            @Param("nombre") String nombre,
            @Param("estado") String estado,
            @PageableDefault(size = 10,page = 0,sort = "id")Pageable pageable);

     /*consulta de mentor y director
     * SELECT s.semilleroId,oi.nombre,s.estado,intse.usuarioId
	FROM semillero s
	INNER JOIN integrante_semillero intse ON s.semilleroId=intse.semilleroId
    INNER JOIN organismo_de_investigacion oi ON s.semilleroId= oi.id
    inner join grupo g on s.grupoId=g.grupoId
    inner join integrante_grupo intg on g.grupoId=intg.grupoId
    WHERE (intse.rolId=2 or intg.rolGrupoId=1) AND intse.usuarioId=3;
     * */
    @Query(value = "SELECT s.semilleroId,oi.nombre,s.estado,intse.usuarioId " +
            "FROM semillero s " +
            "INNER JOIN integrante_semillero intse ON s.semilleroId=intse.semilleroId " +
            "    INNER JOIN organismo_de_investigacion oi ON s.semilleroId= oi.id " +
            "    WHERE intse.rolId=2 AND intse.usuarioId=(:idMentor);",nativeQuery = true)
    Page<List<ListarSemilleroPorIdMentor>> listarSemilleroPorIdMentor(
            @Param("idMentor") int idMentor,
            @PageableDefault(size = 10,page = 0,sort = "id")Pageable pageable);

    @Query(value = "select s.semilleroId,oi.nombre,s.estado,ig.usuarioId " +
            " from semillero as s " +
            "      inner join organismo_de_investigacion oi on oi.id=s.semilleroId " +
            "      inner join grupo g on g.grupoId=s.grupoId " +
            "      inner join integrante_grupo ig on g.grupoId=ig.grupoId " +
            "      where " +
            "      (LOWER(oi.nombre) LIKE %:nombre% OR LOWER(oi.nombre) = COALESCE(LOWER(:nombre),LOWER(oi.nombre) ) OR :nombre IS NULL) " +
            "      AND (LOWER(s.estado) = COALESCE(LOWER(:estado),LOWER(s.estado)) OR :estado IS NULL) " +
            "      AND ((s.semilleroId) like (:semilleroId) or (s.semilleroId)= coalesce((:semilleroId),(s.semilleroId)) or (:semilleroId) IS NULL) " +
            "      AND ig.rolGrupoId=1 and ig.usuarioId=(:idDirector);",nativeQuery = true)
    Page<List<ListarSemilleroPorIdMentor>> listarxFiltroSemilleroPorIdDirector(
            @Param("idDirector") Long idDirector,
            @Param("semilleroId") Integer semilleroId,
            @Param("nombre") String nombre,
            @Param("estado") String estado,
            @PageableDefault(size = 10,page = 0,sort = "id")Pageable pageable);

    @Query(value = "select s.semilleroId,oi.nombre,s.estado,ig.usuarioId " +
            "from semillero as s " +
            "inner join organismo_de_investigacion oi on oi.id=s.semilleroId " +
            "inner join grupo g on g.grupoId=s.grupoId " +
            "inner join integrante_grupo ig on g.grupoId=ig.grupoId " +
            "where ig.rolGrupoId=1 and ig.usuarioId=(:idDirector);",nativeQuery = true)
    Page<List<ListarSemilleroPorIdMentor>> listarSemilleroPorIdDirector(
            @Param("idDirector") Long idDirector,
            @PageableDefault(size = 10,page = 0,sort = "id")Pageable pageable);
}
