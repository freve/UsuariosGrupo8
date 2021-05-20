package com.ufps.entities;

import java.util.Date;

import lombok.Data;

@Data
public class Persona {

	private  long documento;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String email;
	private Date fechaNacimiento;
	
	public Persona(long documento, String nombre, String apellidos, int telefono, String email, Date fechaNacimiento) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
