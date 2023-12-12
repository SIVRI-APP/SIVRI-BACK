package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudObservaciónListarProyección;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioSolicitudObservacionesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

public interface UsuarioSolicitudObservacionesRepository extends JpaRepository<UsuarioSolicitudObservacionesEntity, Long> {


    @Query(value = "select " +
            " uso.id, " +
            " uso.observación, " +
            " uso.fechaObservación " +
            "from " +
            " usuario_solicitud_observaciones uso  " +
            "where " +
            " :solicitudUsuarioId = uso.solicitudUsuarioId " +
            " and uso.resuelta = false"
            , nativeQuery = true)
    Page<UsuarioSolicitudObservaciónListarProyección> listar(
            @Param("solicitudUsuarioId") long solicitudUsuarioId,
            @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable);

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

    boolean existsById (long id);
}
