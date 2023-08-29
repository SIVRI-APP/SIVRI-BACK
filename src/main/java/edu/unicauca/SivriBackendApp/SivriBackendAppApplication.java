package edu.unicauca.SivriBackendApp;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.PosgradoEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.RolAcademicoEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SivriBackendAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SivriBackendAppApplication.class, args);
	}

}
