package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.SemilleroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISemilleroRepository extends JpaRepository<SemilleroEntity, Integer> {
    //@Query("SELECT s FROM Semillero s WHERE s.idSemillero = ?1 OR s.nombreSemillero = ?2")
    public List<SemilleroEntity> findByIdAndNombreLikeIgnoreCase(int idSemillero, String nombre);
    public List<SemilleroEntity> findByNombreLikeIgnoreCase(String nombre);
    //public List<SemilleroEntity> findByNombre( String nombre);
    public Boolean existsByNombre(String nombre);
    //@Query("SELECT s FROM semillero s WHERE s.grupoId = ?1")

    public List<SemilleroEntity> findByGrupoId(int idGrupo);
    //@Query("SELECT DISTINCT i.semilleroId FROM integrante_semillero i JOIN FETCH i.semilleroId s WHERE  s.usuarioNumeroDocumento = ?1")
   // public List<SemilleroEntity> findByusuarioNumeroDocumento(String idMentor);

}
