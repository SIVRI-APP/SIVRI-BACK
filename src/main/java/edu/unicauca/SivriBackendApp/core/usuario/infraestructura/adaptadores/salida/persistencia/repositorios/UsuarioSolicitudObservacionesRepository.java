package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioSolicitudObservacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UsuarioSolicitudObservacionesRepository extends JpaRepository<UsuarioSolicitudObservacionesEntity, Long> {

    @Query(value = "select " +
            " count(uso.fechaObservación) " +
            "from " +
            " usuario_solicitud_observaciones uso  " +
            "where " +
            " :solicitudUsuarioId = uso.solicitudUsuarioId " +
            " and uso.resuelta = false"
            , nativeQuery = true)
    Integer solicitudConObservacionesPendientes(
            @Param("solicitudUsuarioId") long solicitudUsuarioId);

}
