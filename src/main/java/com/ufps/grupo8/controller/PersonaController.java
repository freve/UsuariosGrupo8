package com.ufps.grupo8.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ufps.grupo8.entities.Persona;
import com.ufps.grupo8.repository.PersonaRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
public class PersonaController {
	
	@Autowired
	PersonaRepository personaRepository;
	
	@GetMapping(path="/persona")
	public String prueba() {
		return "Prueba!";
	}
	
	@GetMapping(path="/persona/{documento}")
	public Persona conseguirPersona(@PathVariable Long documento) {
		return personaRepository.findByDocumento(documento);
	}
	
	@PostMapping("/personas")
	public ResponseEntity<Void> agregarPersona(@RequestBody Persona persona){
		Persona auxPersona= personaRepository.save(persona);
		System.out.println(persona);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{documento}")
				.buildAndExpand(auxPersona.getNombre()).toUri(); //Retorna la nueva url donde se consigue el json

		return ResponseEntity.created(uri).build();
	}
	
}
