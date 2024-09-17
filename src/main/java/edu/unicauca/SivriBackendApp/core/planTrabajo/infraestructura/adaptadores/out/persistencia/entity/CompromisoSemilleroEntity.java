package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "compromiso_semillero")
@Data
public class CompromisoSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 200)
    private String nombre;

    //relacion 1a* con entidad actividadPlanTrabajo
    //@OneToMany(mappedBy = "compromiso", fetch = FetchType.LAZY)
    //private List<ActividadPlanTrabajoEntity> actividades;
    //private UsuarioEntity responsableUsuario;
}
