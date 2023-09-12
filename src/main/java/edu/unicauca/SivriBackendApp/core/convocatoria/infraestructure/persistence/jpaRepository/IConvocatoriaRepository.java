package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.ConvocatoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConvocatoriaRepository extends JpaRepository<ConvocatoriaEntity, Long>{

    // Método personalizado para obtener una Convocatoria por su ID y eliminadoLogico=false
    ConvocatoriaEntity findByIdAndEliminadoLogicoFalse(Long id);

    // Método de consulta personalizada para obtener las convocatorias no eliminadas
    List<ConvocatoriaEntity> findByEliminadoLogicoFalse();
}
