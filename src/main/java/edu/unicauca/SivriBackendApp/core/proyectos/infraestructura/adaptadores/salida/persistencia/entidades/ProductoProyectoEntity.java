package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.CategoriaProductoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.TipoProductoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto_proyecto")
@Getter
@Setter
public class ProductoProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_proyecto_seq")
    @SequenceGenerator(name = "producto_proyecto_seq", sequenceName = "producto_proyecto_seq", initialValue = 10, allocationSize = 1)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private CategoriaProductoEnum categoria;

    @Enumerated(EnumType.STRING)
    private TipoProductoEnum tipo;

    @Column(length = 1000, nullable = false)
    private String descripcion;

}
