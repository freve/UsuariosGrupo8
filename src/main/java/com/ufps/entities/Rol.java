package com.ufps.entities;

import java.util.Date;

import lombok.Data;

@Data
public class Rol extends Persona {

	private String nombreRol;
	private String descripcion;
	private Permiso permiso;
	
	public Rol(long documento, String nombre, String apellidos, int telefono, String email, Date fechaNacimiento,
			String nombreRol, String descripcion, Permiso permiso) {
		super(documento, nombre, apellidos, telefono, email, fechaNacimiento);
		this.nombreRol = nombreRol;
		this.descripcion = descripcion;
		this.permiso = permiso;
	}
	
}
