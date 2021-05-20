package com.ufps.entities;

import java.util.Date;

import lombok.Data;

@Data
public class Usuario extends Rol {


	private String nickname;
	private String contraseña;
	public Usuario(long documento, String nombre, String apellidos, int telefono, String email, Date fechaNacimiento,
			String nombreRol, String descripcion, Permiso permiso, String nickname, String contraseña) {
		super(documento, nombre, apellidos, telefono, email, fechaNacimiento, nombreRol, descripcion, permiso);
		this.nickname = nickname;
		this.contraseña = contraseña;
	}
	
}	

