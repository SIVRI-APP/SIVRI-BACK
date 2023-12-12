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

  boolean existsByEmail(String email);

  boolean existsByUsuarioId(long usuarioId);

}
