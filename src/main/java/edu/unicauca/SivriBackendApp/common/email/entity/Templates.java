package edu.unicauca.SivriBackendApp.common.email.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "templates")
public class Templates {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String nombreTemplate;
	
	private String description;
	
	private String vars;
	
}
