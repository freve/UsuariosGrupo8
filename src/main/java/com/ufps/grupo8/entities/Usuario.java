package com.ufps.grupo8.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Usuario implements Serializable{

	
	@Id
	private String nickname;
	
	@Column
	private String contraseña;
	
	@Column
	private String foto;
	
	@Column	
	private Date ultimoAcceso;
	
	@OneToOne
	private Persona persona;
	@ManyToOne
	private Rol rol;
	
	public Usuario() {
		
	}
	
	

	public Usuario(String nickname, String contraseña, String foto, Date ultimoAcceso, Rol rol) {
		super();
		this.nickname = nickname;
		this.contraseña = contraseña;
		this.foto = foto;
		this.ultimoAcceso = ultimoAcceso;
		this.rol = rol;
	}



	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}	
	
}
