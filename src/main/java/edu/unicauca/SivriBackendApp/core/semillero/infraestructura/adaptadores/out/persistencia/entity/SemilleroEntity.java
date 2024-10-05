package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoEntity;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "semillero")
@Data
//relacion de herencia
@PrimaryKeyJoinColumn(name = "semillero_Id")
public class SemilleroEntity extends OrganismoDeInvestigacionEntity {

    @Column(nullable = false,length = 10)
    @Enumerated(EnumType.STRING)
    private SemilleroEstado estado;

    @Column(length = 100)
    private String correo;

    @Column(length = 25)
    private String sede;

    //relacion ce 1a* con integranteSemillero

    //@JsonBackReference
    //@JsonIgnore
    @OneToMany(mappedBy = "semillero",fetch = FetchType.LAZY)
    private List<IntegranteSemilleroEntity> integrantes;
    //relacion 1a* con entidad documentoSemillero
    @OneToMany(mappedBy = "semillero", fetch = FetchType.LAZY)
    private List<DocumentoSemilleroEntity> documentosSemillero;

    //relacion 1a* con entidad lineadeInvestiacion
    @OneToMany(mappedBy = "semillero",fetch = FetchType.LAZY)
    private List<LineaInvestigacionEntity> lineasInvestigacion;

    //relacion de *a1 con entidad grupo
    //@PrimaryKeyJoinColumn(name = "grupoId")

    @JsonManagedReference
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "grupoId")
    private GrupoEntity grupo;

    //relacion de 1a* con plan de trabajo
    /*@JsonBackReference
    @OneToMany(mappedBy = "semillero",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<PlanTrabajoEntity> planesTrabajo;
*/

    @Override
    public String toString() {
        return "SemilleroEntity{" +
                "estado=" + estado +
                ", correo='" + correo + '\'' +
                ", sede='" + sede + '\'' +
                ", grupo=" + grupo +
                '}';
    }
}
