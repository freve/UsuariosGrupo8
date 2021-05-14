package com.ufps.helloworld;

public class HelloWorldBean {

	private String mensaje;

	public HelloWorldBean(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [mensaje=" + mensaje + "]";
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
