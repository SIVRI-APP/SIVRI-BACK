package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.Data;

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
