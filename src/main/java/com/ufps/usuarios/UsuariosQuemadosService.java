package com.ufps.usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class UsuariosQuemadosService {

	private static List<Usuario> usuarios = new ArrayList();
	private static int idCounter =0;
	static {
		usuarios.add(new Usuario(++idCounter,"Ivan", "Learning Java", new Date(), false));
		usuarios.add(new Usuario(++idCounter,"Mauri", "Learning Python", new Date(), false));
		usuarios.add(new Usuario(++idCounter,"Uribe", "Learning C", new Date(), false));
	}
	
	public List<Usuario>  findAll(){
		return usuarios;
	}
	
}
