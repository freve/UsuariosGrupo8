package com.ufps.entities;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class Permiso {
		
	private int id;
	private boolean autorizacion;
	private String nombre;
	private Date fechaAsignacion;
	private ArrayList<Funcionalidad> funcionalidades;
	public Permiso(int id, boolean autorizacion, String nombre, Date fechaAsignacion,
			ArrayList<Funcionalidad> funcionalidades) {
		super();
		this.id = id;
		this.autorizacion = autorizacion;
		this.nombre = nombre;
		this.fechaAsignacion = fechaAsignacion;
		this.funcionalidades = funcionalidades;
	}
	
	
	
}
