package com.ufps.grupo8.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

import com.ufps.grupo8.entities.Persona;
import com.ufps.grupo8.repository.PersonaRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
public class PersonaController {
	
	@Autowired
	PersonaRepository personaRepository;
	
	@GetMapping(path="/persona")
	public List<Persona> listaPersonas() {
		return personaRepository.findAll();
	}
	
	@GetMapping(path="/persona/{documento}")
	public Persona conseguirPersona(@PathVariable Long documento) {
		System.out.println(personaRepository.findByDocumento(documento));
		return personaRepository.findByDocumento(documento);
	}
	
	@PostMapping("/persona")
	public ResponseEntity<Void> agregarPersona(@RequestBody Persona persona){
		Persona auxPersona= personaRepository.save(persona);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{documento}")
				.buildAndExpand(auxPersona.getDocumento()).toUri(); //Retorna la nueva url donde se consigue el json

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(path="/persona")
	public ResponseEntity<Persona> actualizarPersona(@RequestBody Persona persona) {
		if (!personaRepository.existsByDocumento(persona.getDocumento())) {
			return ResponseEntity.noContent().build();
		}
		Persona auxPersona = personaRepository.save(persona);
		return new ResponseEntity<Persona>(auxPersona, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/persona/{documento}")
	public ResponseEntity<Void> eliminarPersona(@PathVariable Long documento){
		
		if(personaRepository.existsByDocumento(documento)) {
			personaRepository.deleteByDocumento(documento);
			return ResponseEntity.noContent().build();
		}
	
		return ResponseEntity.notFound().build();		
	}
}
