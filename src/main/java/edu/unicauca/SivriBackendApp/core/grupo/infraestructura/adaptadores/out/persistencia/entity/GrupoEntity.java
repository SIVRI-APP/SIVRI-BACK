package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.FacultadEntity;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoEstado;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.OrganismoDeInvestigacionEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.SemilleroEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "grupo")
//relacion de herencia
@PrimaryKeyJoinColumn(name = "grupoId")
@Data
public class GrupoEntity extends OrganismoDeInvestigacionEntity {

    @Column(nullable = false,length = 10)
    @Enumerated(EnumType.STRING)
    private GrupoEstado estado;
    @Column(length = 95)
    private String direccion;
    @Column(length = 45)
    private String telefono;
    @Column(length = 50)
    @Email
    private String email;
    @Column(length = 100)
    private String sitioWeb;
    @Column(length = 10)
    private String escalafonColciencias;
    @Column(length = 120)
    private String direccionGrupLac;
    @Column(length = 45)
    private String codigoColciencias;
    @Column(length = 100)
    private String centroInvestigaciones;
    @Column(length = 1545)
    private String realizaciones;
    @Column(length = 1545)
    private String perspectivas;

    //relacion *a1 con entidad facultad
    @ManyToOne
    @JoinColumn(name = "facultadId")
    private FacultadEntity facultad;

    // relacion 1a* con entidad integranteGrupo
    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<IntegranteGrupoEntity> integrantesGrupo;

    // relacion 1a* con entidad observacionGrupo
    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY)
    private List<ObservacionGrupoEntity> observacionesGrupo;

    // relacion 1a* con entidad semillero
    @OneToMany(mappedBy = "grupo",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<SemilleroEntity> semilleros;

    @Override
    public String toString() {
        return "GrupoEntity{" +
                "estado=" + estado +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", sitioWeb='" + sitioWeb + '\'' +
                ", escalafonColciencias='" + escalafonColciencias + '\'' +
                ", direccionGrupLac='" + direccionGrupLac + '\'' +
                ", codigoColciencias='" + codigoColciencias + '\'' +
                ", centroInvestigaciones='" + centroInvestigaciones + '\'' +
                ", realizaciones='" + realizaciones + '\'' +
                ", perspectivas='" + perspectivas + '\'' +
                ", facultad=" + facultad +
                '}';
    }
}
