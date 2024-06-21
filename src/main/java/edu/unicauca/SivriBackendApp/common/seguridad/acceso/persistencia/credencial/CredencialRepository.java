package edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CredencialRepository extends JpaRepository<Credencial, Integer> {

  boolean existsByEmail(String email);

  Optional<Credencial> findByEmail(String email);

  Optional<Credencial> findByUserId(long userId);

  Optional<Credencial> findByPasswordRecoveryCode(String passwordRecoveryCod);

  @Query(value = "SELECT CONCAT('FUNCIONARIO:', rol_fun.nombre) AS authorities " +
          "FROM credencial cre " +
          "INNER JOIN usuario usu ON cre.userId = usu.id  " +
          "INNER JOIN funcionario fun ON fun.usuarioId = usu.id AND fun.estado = 1 " +
          "INNER JOIN rol_funcionario rol_fun ON rol_fun.id = fun.rolId " +
          "WHERE cre.email = :email "
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesFuncionario (@Param("email") String email);

  @Query(value = "select " +
          " CONCAT('SEMILLERO:', rs.rolSemillero) as authorities " +
          "from " +
          " credencial cre " +
          "INNER JOIN usuario usu ON cre.userId = usu.id " +
          "inner join integrante_semillero is2 on is2.usuarioId = usu.id  " +
          "inner join rol_semillero rs on rs.id = is2.rolId  " +
          "where cre.email = :email"
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesSemillero (@Param("email") String email);

  @Query(value = "select " +
          " CONCAT('SEMILLERO:', rg.rolGrupo) as authorities " +
          "from " +
          " credencial cre " +
          "INNER JOIN usuario usu ON cre.userId = usu.id " +
          "inner join integrante_grupo ig on ig.usuarioId = usu.id  " +
          "inner join rol_grupo rg on rg.id = ig.rolGrupoId  " +
          "where cre.email = :email"
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesGrupo (@Param("email")String email);
}
