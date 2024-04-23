package edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface RepositorioCredencial extends JpaRepository<Credencial, Integer> {

  Optional<Credencial> findByEmail(String email);

  Optional<Credencial> findByUsuarioId(long usuarioId);

  @Query(value = "SELECT CONCAT('FUNCIONARIO:', rol_fun.nombre) AS authorities " +
          "FROM _credencial _cre " +
          "INNER JOIN usuario usu ON _cre.usuarioId = usu.id  " +
          "INNER JOIN funcionario fun ON fun.usuarioId = usu.id AND fun.estado = 1 " +
          "INNER JOIN rol_funcionario rol_fun ON rol_fun.id = fun.rolId " +
          "WHERE _cre.email = :email "
          , nativeQuery = true)
  List<IGetAuthorities> getAuthoritiesFuncionario (@Param("email") String email);

  boolean existsByEmail(String email);

  @Query(value = "SELECT COUNT(_cre.recuperarContraseña) " +
          "FROM _credencial _cre " +
          "WHERE _cre.recuperarContraseña = :numero"
          , nativeQuery = true)
  int códigoAleatorioParaRecuperarContraseñaExiste(@Param("numero")int numero);

  @Modifying
  @Query(value = "UPDATE _credencial " +
          "SET recuperarContraseña = 0, " +
          "recuperarContraseñaFechaCreacion = CURDATE() " +
          "WHERE recuperarContraseña != 0 AND " +
          "recuperarContraseñaFechaCreacion < DATE_SUB(NOW(), interval 2 month)",
          nativeQuery = true)
  int limpiarCódigosAntiguosRecuperaciónDeContraseña();

  @Query(value = "select " +
          " count(_cre.id) as existe " +
          "from " +
          " _credencial _cre " +
          "where " +
          " _cre.recuperarContraseña = :codigoRecuperarContraseña " +
          " and _cre.email = :email " +
          " and _cre.recuperarContraseña != 0",
          nativeQuery = true)
  int validarCodigoRecuperarContraseña(String email, int codigoRecuperarContraseña);
}
