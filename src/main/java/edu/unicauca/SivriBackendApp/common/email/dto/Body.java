package edu.unicauca.SivriBackendApp.common.email.dto;

public class Body {

	public Body(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
