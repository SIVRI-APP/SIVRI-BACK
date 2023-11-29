package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioSolicitudEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioSolicitudRepository extends JpaRepository<UsuarioSolicitudEntity, Long> {
}
