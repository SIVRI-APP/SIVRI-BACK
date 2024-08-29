package edu.unicauca.SivriBackendApp;

import edu.unicauca.SivriBackendApp.common.email.dto.MetaData;
import edu.unicauca.SivriBackendApp.common.email.dto.SendRequest;
import edu.unicauca.SivriBackendApp.common.email.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication

public class SivriBackendAppApplication{

	public static void main(String[] args) {
		SpringApplication.run(SivriBackendAppApplication.class, args);
	}
	/*@Autowired
	SendMessageService servicioEmail;
	@Override
	public void run(String... args) throws Exception {
		SendRequest datosenvio=new SendRequest("yuranyguev@unicauca.edu.co","prueba",4, List.of(new MetaData("semilleroId","2"),new MetaData("nombreSemillero","nombre semillero")));
		servicioEmail.sendMessage(datosenvio);
	}*/
}
