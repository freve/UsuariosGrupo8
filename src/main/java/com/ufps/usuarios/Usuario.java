package com.ufps.usuarios;

import java.util.Date;

public class Usuario {

	private long id ;
	private String usuario;
	private String descripcion;
	private Date fecha;
	private boolean done;
	public Usuario(long id, String usuario, String descripcion, Date fecha, boolean done) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.done = done;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}	
	
}
