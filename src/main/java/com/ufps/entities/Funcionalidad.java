package com.ufps.entities;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Funcionalidad {
	
	private int id;
	private String nombre;
	private ArrayList<String> url;
	public Funcionalidad(int id, String nombre, ArrayList<String> url) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.url = url;
	}
	
}
