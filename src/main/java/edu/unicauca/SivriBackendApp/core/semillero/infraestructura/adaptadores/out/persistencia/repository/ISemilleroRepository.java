package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroSemilleros;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarSemilleroPorIdMentor;
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

     @Query(value = "SELECT s.semilleroId,oi.nombre,s.correo,oi.fechaCreacion,s.estado " +
            "FROM semillero s left JOIN organismo_de_investigacion oi " +
            "ON s.semilleroId=oi.id " +
            "WHERE " +
            "   (LOWER(oi.nombre) LIKE %:nombre% OR LOWER(oi.nombre) = COALESCE(LOWER(:nombre),LOWER(oi.nombre) ) OR :nombre IS NULL) "  +
            "   AND (LOWER(s.correo) = COALESCE(LOWER(:correo),LOWER(s.correo)) OR :correo IS NULL) " +
            "   AND (LOWER(s.estado) = COALESCE(LOWER(:estado),LOWER(s.estado)) OR :estado IS NULL);",nativeQuery = true)
    Page<List<ListarConFiltroSemilleros>> listarSemillerosConFiltro(
            @Param("nombre") String nombre,
            @Param("correo") String correo,
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


}
