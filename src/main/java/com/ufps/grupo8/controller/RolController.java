package com.ufps.grupo8.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ufps.grupo8.entities.Permiso;
import com.ufps.grupo8.entities.Persona;
import com.ufps.grupo8.entities.Rol;
import com.ufps.grupo8.repository.PermisoRepository;
import com.ufps.grupo8.repository.PersonaRepository;
import com.ufps.grupo8.repository.RolRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
public class RolController {

	@Autowired
	RolRepository rolRepository;
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	PermisoRepository permisoRepository;
	
	@GetMapping(path="/rol")
	public List<Rol> listaRoles() {
		return rolRepository.findAll();
	}
	
	@GetMapping(path="/rol/{id}")
	public Rol conseguirRol(@PathVariable Integer id) {
		return rolRepository.findById(id).get();
	}
	
	
	@PostMapping(path="/rol")
	public ResponseEntity<Void> agregarRol(@RequestBody Rol rol){
		Rol auxRol= rol;
		Permiso auxPermiso = permisoRepository.findById(rol.getPermiso().getId()).get();
		auxRol.setPermiso(auxPermiso);
		rolRepository.save(auxRol);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(auxRol.getId()).toUri(); //Retorna la nueva url donde se consigue el json
		System.out.println(ResponseEntity.created(uri).build());

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(path="/rol")
	public ResponseEntity<Rol> actualizarRol(@RequestBody Rol rol) {
		if (!rolRepository.existsById(rol.getId())) {
			return ResponseEntity.noContent().build();
		}
		Rol auxRol= rolRepository.save(rol);
		return new ResponseEntity<Rol>(rol, HttpStatus.OK);
	}
	
	@PutMapping(path="/rol/permiso")
	public ResponseEntity<Rol> actualizarPermisoRol(@RequestBody Rol rol) {
		if (!rolRepository.existsById(rol.getId())) {
			return ResponseEntity.noContent().build();
		}
		
		Permiso auxPermiso = permisoRepository.findById(rol.getPermiso().getId()).get();
		Rol auxRol= rol; 
		auxRol.setPermiso(auxPermiso);
		
		rolRepository.save(rol);		
		return new ResponseEntity<Rol>(rol, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/rol/{id}")
	public ResponseEntity<Void> eliminarRol(@PathVariable Integer id){
		
		if(personaRepository.existsById(id)) {
			personaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
	
		return ResponseEntity.notFound().build();		
	}
	
}
