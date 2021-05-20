package com.ufps.entities;

import java.util.Date;

import lombok.Data;

@Data
public class Perfil extends Usuario {
	
	private String foto;
	private String descripcion;
	private Date fechaAcceso;
	
	
	public Perfil(long documento, String nombre, String apellidos, int telefono, String email, Date fechaNacimiento,
			String nombreRol, String descripcion, Permiso permiso, String nickname, String contraseña, String foto,
			String descripcion2, Date fechaAcceso) {
		super(documento, nombre, apellidos, telefono, email, fechaNacimiento, nombreRol, descripcion, permiso, nickname,
				contraseña);
		this.foto = foto;
		descripcion = descripcion2;
		this.fechaAcceso = fechaAcceso;
	}
	
	

}
