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
          "INNER JOIN usuario usu ON cre.USER_ID = usu.ID  " +
          "INNER JOIN funcionario fun ON fun.USUARIO_ID = usu.ID AND fun.estado = 1 " +
          "INNER JOIN rol_funcionario rol_fun ON rol_fun.ID = fun.ROL_ID " +
          "WHERE cre.EMAIL = :email "
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesFuncionario (@Param("email") String email);

  @Query(value = "select " +
          " CONCAT('PROYECTO:', rp.nombre) as authorities " +
          "from " +
          " credencial cre " +
          "INNER JOIN usuario usu ON cre.USER_ID = usu.id " +
          "inner join integrante_proyecto ip on iP.USUARIO_ID = usu.id  " +
          "inner join rol_proyecto rp on rp.id = ip.ROL_ID  " +
          "where cre.email = :email"
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesProyecto (@Param("email") String email);

  @Query(value = "select " +
          " CONCAT('SEMILLERO:', rs.ROL_SEMILLERO) as authorities " +
          "from " +
          " credencial cre " +
          "INNER JOIN usuario usu ON cre.USER_ID = usu.id " +
          "inner join integrante_semillero is2 on is2.USUARIO_ID = usu.id  " +
          "inner join rol_semillero rs on rs.id = is2.ROL_ID  " +
          "where cre.email = :email"
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesSemillero (@Param("email") String email);

  @Query(value = "select " +
          " CONCAT('GRUPO:', rg.ROL_GRUPO) as authorities " +
          "from " +
          " credencial cre " +
          "INNER JOIN usuario usu ON cre.USER_ID = usu.id " +
          "inner join integrante_grupo ig on ig.USUARIO_ID = usu.id  " +
          "inner join rol_grupo rg on rg.id = ig.ROL_GRUPO_ID  " +
          "where cre.email = :email"
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesGrupo (@Param("email")String email);
}
