package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioSolicitudConversacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioSolicitudConversacionRepository extends JpaRepository<UsuarioSolicitudConversacionEntity, Long> {
}
