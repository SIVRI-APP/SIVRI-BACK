package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.proyecciones.ConvocatoriaInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.ConvocatoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ConvocatoriaRepository extends JpaRepository<ConvocatoriaEntity, Long>{
    boolean existsByNombre(String nombre);

    @Query("SELECT convocatoria " +
            "FROM ConvocatoriaEntity convocatoria " +
            "LEFT JOIN FETCH convocatoria.checklist checklist " +
            "LEFT JOIN FETCH checklist.documentoConvocatoria doc " +
            "WHERE convocatoria.id = :convocatoriaId"
    )
    Optional<ConvocatoriaInformacionDetalladaProyeccion> obtenerConvocatoriaInformacionDetallada(@Param("convocatoriaId") long solicitudUsuarioId);
}
