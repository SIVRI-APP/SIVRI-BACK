package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioSolicitudObservacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioSolicitudObservacionesRepository extends JpaRepository<UsuarioSolicitudObservacionesEntity, Long> {

    Boolean existsBySolicitudUsuarioId(Long solicitudUsuarioId);
}
