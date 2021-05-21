package com.ufps.grupo8.controller;

import java.net.URI;
import java.util.List;

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

import com.ufps.grupo8.entities.Funcionalidad;
import com.ufps.grupo8.entities.Permiso;
import com.ufps.grupo8.repository.PermisoRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
public class PermisoController {

	@Autowired
	PermisoRepository permisoRepository;
	
	@GetMapping(path="/permiso")
	public List<Permiso> listaPermisos() {
		return permisoRepository.findAll();
	}
	
	@GetMapping(path="/permiso/{id}")
	public Permiso conseguirPermiso(@PathVariable Integer id) {
		return permisoRepository.findById(id).get();
	}
	
	
	@PostMapping(path="/permiso")
	public ResponseEntity<Void> agregarPermiso(@RequestBody Permiso permiso) {
		Permiso auxPermiso= permiso;
		permisoRepository.save(auxPermiso);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(auxPermiso.getId()).toUri(); // Retorna la nueva url donde se consigue el json
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(path="/permiso/funcionalidad")
	public ResponseEntity<Permiso> agregandoFuncionalidades(@RequestBody Permiso permiso) {
		if (!permisoRepository.existsById(permiso.getId())) {
			return ResponseEntity.noContent().build();
		}
		
		List<Funcionalidad> auxFuncionalidades = permiso.getFuncionalidades();
		
		Permiso auxPermiso = permisoRepository.findById(permiso.getId()).get();
		
		auxPermiso.setFuncionalidades(auxFuncionalidades);
		
		auxPermiso=permisoRepository.save(auxPermiso);		
	
		return new ResponseEntity<Permiso>(auxPermiso, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/permiso/{id}")
	public ResponseEntity<Void> eliminarPermiso(@PathVariable Integer id) {

		if (permisoRepository.existsById(id)) {
			permisoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
	
}
