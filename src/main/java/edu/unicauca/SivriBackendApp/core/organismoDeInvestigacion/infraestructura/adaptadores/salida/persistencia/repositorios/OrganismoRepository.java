package edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ListarOrganismosParaAsociarProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.OrganismoDeInvestigacionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganismoRepository extends JpaRepository<OrganismoDeInvestigacionEntity, Integer>{
    @Query("SELECT semillero " +
            "FROM SemilleroEntity semillero " +
            "WHERE semillero.id = :semilleroId"
    )
    Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> obtenerSemilleroSimple(@Param("semilleroId") long semilleroId);

    @Query("SELECT grupo " +
            "FROM GrupoEntity grupo " +
            "LEFT JOIN FETCH grupo.integrantes integrantes " +
            "LEFT JOIN FETCH integrantes.rolGrupo rol " +
            "LEFT JOIN FETCH integrantes.usuario usuario " +
            "WHERE grupo.id = :grupoId and usuario.tipoUsuario = 'DOCENTE'"
    )
    Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> obtenerGrupoSimple(@Param("grupoId") long grupoId);

    @Query("SELECT semillero " +
            "FROM SemilleroEntity semillero " +
            "LEFT JOIN FETCH semillero.integrantes integrantes " +
            "LEFT JOIN FETCH integrantes.rolSemillero rol " +
            "LEFT JOIN FETCH integrantes.usuario usuario " +
            "WHERE semillero.id = :semilleroId and usuario.tipoUsuario = 'DOCENTE'"
    )
    Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> listarConFiltroIntegrantesDocenteSemillero(@Param("semilleroId") long semilleroId);

    @Query("SELECT grupo " +
            "FROM GrupoEntity grupo " +
            "LEFT JOIN FETCH grupo.integrantes integrantes " +
            "LEFT JOIN FETCH integrantes.rolGrupo rol " +
            "LEFT JOIN FETCH integrantes.usuario usuario " +
            "WHERE grupo.id = :grupoId"
    )
    Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> listarConFiltroIntegrantesGrupo(@Param("grupoId") long grupoId);

    @Query("SELECT semillero " +
            "FROM SemilleroEntity semillero " +
            "LEFT JOIN FETCH semillero.integrantes integrantes " +
            "LEFT JOIN FETCH integrantes.rolSemillero rol " +
            "LEFT JOIN FETCH integrantes.usuario usuario " +
            "LEFT JOIN FETCH OrganismoDeInvestigacionEntity org on org.id = semillero.id " +
            "LEFT JOIN FETCH CooperacionEntity cop on cop.organismoDeInvestigacion.id = org.id " +
            "LEFT JOIN FETCH ProyectoEntity p on p.id = cop.proyecto.id " +
            "WHERE semillero.id = :semilleroId " +
            "AND p.id = :proyectoId " +
            "AND cop.principal = true " +
            "AND usuario.tipoUsuario != 'ADMINISTRATIVO' " +
            "AND NOT EXISTS ( " +
            "    SELECT 1 " +
            "    FROM IntegranteProyectoEntity ip " +
            "    WHERE ip.usuario.id = usuario.id " +
            "      AND ip.proyecto.id = p.id ) "
    )
    Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> listarConFiltroIntegrantesSemillero(
            @Param("semilleroId") long semilleroId,
            @Param("proyectoId") long proyectoId
    );

    @Query("SELECT grupo " +
            "FROM GrupoEntity grupo " +
            "LEFT JOIN FETCH grupo.integrantes integrantes " +
            "LEFT JOIN FETCH integrantes.rolGrupo rol " +
            "LEFT JOIN FETCH integrantes.usuario usuario " +
            "WHERE grupo.id = :grupoId and usuario.tipoUsuario = 'DOCENTE'"
    )
    Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> listarConFiltroIntegrantesDocenteGrupo(@Param("grupoId") long grupoId);

    @Query(value = "select DISTINCT " +
            " org.id, " +
            " org.nombre " +
            "from organismo_de_investigacion org " +
            "left join semillero sem on sem.semillero_id = org.id " +
            "left join integrante_semillero ints on ints.semillero_id = sem.semillero_id " +
            "left join usuario usu on usu.id = ints.usuario_id " +
            "where " +
        "        (:id is null or LOWER(org.id) like LOWER('%' || :id || '%')) " +
            "    and (:nombre is null or LOWER(org.nombre) like LOWER('%' || :nombre || '%')) " +
            "    and (:usuarioAutenticadoId is null or LOWER(usu.id) like LOWER('%' || :usuarioAutenticadoId || '%')) " +
            "    and sem.estado = 'ACTIVO' " +
            "    or sem.estado = 'ACTIVO_PENDIENTE_ACTUALIZACION' " +
            "ORDER BY org.ID "
            , nativeQuery = true)
    Page<ListarOrganismosParaAsociarProyectoProyeccion> listarConFiltroSemillero(
            @Param("id") Integer id,
            @Param("nombre") String nombre,
            @Param("usuarioAutenticadoId") Long usuarioAutenticadoId,
            @PageableDefault(sort = "id") Pageable pageable
    );

    @Query(value = "select DISTINCT " +
            " org.id, " +
            " org.nombre " +
            "from organismo_de_investigacion org " +
            "left join grupo g on g.grupo_id = org.id " +
            "left join integrante_grupo intg on intg.grupo_id = g.grupo_id " +
            "left join usuario usu on usu.id = intg.usuario_id " +
            "where " +
            "    (:id is null or LOWER(org.id) like LOWER('%' || :id || '%')) " +
            "    and (:nombre is null or LOWER(org.nombre) like LOWER('%' || :nombre || '%')) " +
            "    and (:usuarioAutenticadoId is null or LOWER(usu.id) like LOWER(('%' || :usuarioAutenticadoId || '%'))) " +
            "    and g.estado = 'ACTIVO' " +
            "ORDER BY org.ID "
            , nativeQuery = true)
    Page<ListarOrganismosParaAsociarProyectoProyeccion> listarConFiltroGrupo(
            @Param("id") Integer id,
            @Param("nombre") String nombre,
            @Param("usuarioAutenticadoId") Long usuarioAutenticadoId,
            @PageableDefault(sort = "id") Pageable pageable
    );

    @Query(value = "select " +
            " count(org.id) " +
            "from " +
            " organismo_de_investigacion org " +
            "left join semillero sem on sem.semillero_id = org.id " +
            "where " +
            " org.id = sem.semillero_id " +
            " and sem.semillero_id = :id"
            , nativeQuery = true
    )
    Integer isSemillero(@Param("id") Integer id);

    @Query(value = "select " +
            " count(org.id) " +
            "from " +
            " organismo_de_investigacion org " +
            "left join grupo g on g.grupo_id = org.id " +
            "where " +
            " org.id = g.grupo_id  " +
            " and g.grupo_id = :id"
            , nativeQuery = true
    )
    Integer isGrupo (@Param("id") Integer id);

    Optional<OrganismoDeInvestigacionEntity> findById(Integer id);
}
