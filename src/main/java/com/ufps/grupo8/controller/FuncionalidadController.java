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
import com.ufps.grupo8.repository.FuncionalidadRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
public class FuncionalidadController {

	@Autowired
	FuncionalidadRepository funcionalidadRepository;
	
	
	@GetMapping(path = "/funcionalidad")
	public List<Funcionalidad> listaFuncionalidades(@PathVariable Integer id) {
		return funcionalidadRepository.findAll();
	}
	
	@GetMapping(path = "/funcionalidad/{id}")
	public Funcionalidad conseguirFuncionalidad(@PathVariable Integer id) {
		return funcionalidadRepository.findById(id).get();
	}

	@PostMapping(path = "/funcionalidad")
	public ResponseEntity<Void> agregarUsuario(@RequestBody Funcionalidad funcionalidad) {
		Funcionalidad auxFuncionalidad = funcionalidadRepository.save(funcionalidad);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(auxFuncionalidad.getId()).toUri(); // Retorna la nueva url donde se consigue el json
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(path="/funcionalidad")
	public ResponseEntity<Funcionalidad> actualizarFuncionalidad(@RequestBody Funcionalidad funcionalidad) {
		if (!funcionalidadRepository.existsById(funcionalidad.getId())) {
			return ResponseEntity.noContent().build();
		}
		Funcionalidad auxFuncionalidad= funcionalidadRepository.save(funcionalidad);
		return new ResponseEntity<Funcionalidad>(auxFuncionalidad, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/funcionalidad/{id}")
	public ResponseEntity<Void> eliminarFuncionalidad(@PathVariable Integer id){
		
		if(funcionalidadRepository.existsById(id)) {
			funcionalidadRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
	
		return ResponseEntity.notFound().build();		
	}
}
