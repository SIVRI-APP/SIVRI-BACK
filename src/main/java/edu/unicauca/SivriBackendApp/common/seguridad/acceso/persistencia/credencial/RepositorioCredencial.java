package edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioCredencial extends JpaRepository<Credencial, Integer> {

  Optional<Credencial> findByEmail(String email);

  Optional<Credencial> findByUsuarioId(long usuarioId);

  @Query(value = "SELECT CONCAT('FUNCIONARIO:', rol_fun.nombre) AS authorities " +
          "FROM _credencial _cre " +
          "INNER JOIN usuario usu ON _cre.usuarioId = usu.id  " +
          "INNER JOIN funcionario fun ON fun.usuarioId = usu.id " +
          "INNER JOIN rol_administrativo rol_adm ON rol_adm.funcionarioId = fun.id AND rol_adm.estado = 1 " +
          "INNER JOIN rol_funcionario rol_fun ON rol_fun.id = rol_adm.rolFuncionarioId " +
          "WHERE _cre.email = :email "
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesFuncionario (@Param("email") String email);

  @Query(value = "SELECT CONCAT('SEMILLERO:', rol_sem.rolSemillero) AS authorities " +
          "FROM usuario usu " +
          "INNER JOIN integrante_semillero int_sem ON usu.id = int_sem.usuarioId " +
          "INNER JOIN rol_semillero rol_sem ON rol_sem.id = int_sem.rolId " +
          "WHERE usu.id IN (SELECT usu.id " +
          "FROM _credencial _cre " +
          "INNER JOIN usuario usu ON _cre.usuarioId = usu.id " +
          "INNER JOIN funcionario fun ON fun.usuarioId = usu.id "  +
          "WHERE _cre.email = :email)"
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesSemillero (@Param("email") String email);

  @Query(value = "SELECT CONCAT('GRUPO:', rol_gru.rolGrupo) AS authorities " +
          "FROM usuario usu " +
          "INNER JOIN integrante_grupo int_gru ON usu.id = int_gru.usuarioId " +
          "INNER JOIN rol_grupo rol_gru ON rol_gru.id = int_gru.rolGrupoId " +
          "WHERE usu.id IN ( SELECT usu.id " +
          "FROM _credencial _cre " +
          "INNER JOIN usuario usu ON _cre.usuarioId = usu.id " +
          "INNER JOIN funcionario fun ON fun.usuarioId = usu.id  " +
          "WHERE _cre.email = :email)"
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesGrupo (@Param("email") String email);

}
