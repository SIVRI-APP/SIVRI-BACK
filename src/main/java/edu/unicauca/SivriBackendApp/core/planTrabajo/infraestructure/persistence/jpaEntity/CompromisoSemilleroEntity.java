package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "compromiso_semillero")
@Data
public class CompromisoSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200)
    private String nombre;

    //relacion 1a* con entidad actividadPlanTrabajo
    //@OneToMany(mappedBy = "compromiso", fetch = FetchType.LAZY)
    //private List<ActividadPlanTrabajoEntity> actividades;
    //private UsuarioEntity responsableUsuario;
}
