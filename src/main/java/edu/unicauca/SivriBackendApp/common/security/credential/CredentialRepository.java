package edu.unicauca.SivriBackendApp.common.security.credential;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Integer> {

  Optional<Credential> findByEmail(String email);

  @Query(value = "SELECT CONCAT('FUNCIONARIO:', rol_fun.nombre) AS authorities " +
          "FROM _credential _cre " +
          "INNER JOIN usuario usu ON _cre.usuario_id = usu.id  " +
          "INNER JOIN funcionario fun ON fun.usuarioId = usu.id " +
          "INNER JOIN rol_administrativo rol_adm ON rol_adm.funcionarioId = fun.id AND rol_adm.estado = 1 " +
          "INNER JOIN rol_funcionario rol_fun ON rol_fun.id = rol_adm.rolFuncionarioId " +
          "WHERE _cre.email = :email "
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesFuncionario (@Param("email") String email);

}
