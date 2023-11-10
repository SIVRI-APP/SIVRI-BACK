package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioSolicitudEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioSolicitudRepository extends JpaRepository<UsuarioSolicitudEntity, Long> {
}
