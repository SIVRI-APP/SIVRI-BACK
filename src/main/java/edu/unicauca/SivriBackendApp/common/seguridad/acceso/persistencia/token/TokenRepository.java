package edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

  @Query( "SELECT t " +
          "FROM Token t " +
          "INNER JOIN Credencial cred ON cred.id = t.credencial.id " +
          "WHERE cred.id = :credentialId")
  List<Token> findAllValidTokenByUser(Integer credentialId);

  Optional<Token> findByToken(String token);

}
