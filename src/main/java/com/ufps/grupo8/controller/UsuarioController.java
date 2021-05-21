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

import com.ufps.grupo8.entities.Persona;
import com.ufps.grupo8.entities.Rol;
import com.ufps.grupo8.entities.Usuario;
import com.ufps.grupo8.repository.PersonaRepository;
import com.ufps.grupo8.repository.RolRepository;
import com.ufps.grupo8.repository.UsuarioRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	RolRepository rolRepository;

	@GetMapping(path = "/usuario")
	public List<Usuario> listaUsuarios() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping(path = "/usuario/{nickname}")
	public Usuario conseguirUsuario(@PathVariable String nickname) {
		return usuarioRepository.findByNickname(nickname);
	}

	@PostMapping(path = "/usuario")
	public ResponseEntity<Void> agregarUsuario(@RequestBody Usuario usuario) {
		Usuario auxUsuario = usuario;
		Persona auxPersona = personaRepository.findByDocumento(usuario.getPersona().getDocumento());
		auxUsuario.setPersona(auxPersona);
		usuarioRepository.save(auxUsuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nickname}")
				.buildAndExpand(auxUsuario.getNickname()).toUri(); // Retorna la nueva url donde se consigue el json
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(path = "/usuario/contrasena")
	public ResponseEntity<Usuario> actualizarContraseñaUsuario(@RequestBody Usuario usuario) {
		if (!usuarioRepository.existsByNickname(usuario.getNickname())) {
			return ResponseEntity.noContent().build();
		}
		Usuario auxUsuario = usuarioRepository.findByNickname(usuario.getNickname());
		auxUsuario.setContraseña(usuario.getContraseña());
		auxUsuario= usuarioRepository.save(auxUsuario);
		return new ResponseEntity<Usuario>(auxUsuario, HttpStatus.OK);
	}

	@PutMapping(path = "/usuario/foto")
	public ResponseEntity<Usuario> actualizarFotoUsuario(@RequestBody Usuario usuario) {
		if (!usuarioRepository.existsByNickname(usuario.getNickname())) {
			return ResponseEntity.noContent().build();
		}
		Usuario auxUsuario = usuarioRepository.findByNickname(usuario.getNickname());
		auxUsuario.setFoto(usuario.getFoto());
		auxUsuario = usuarioRepository.save(auxUsuario);
		return new ResponseEntity<Usuario>(auxUsuario, HttpStatus.OK);
	}

	@PutMapping(path = "/usuario/acceso")
	public ResponseEntity<Usuario> actualizarAccesoUsuario(@RequestBody Usuario usuario) {
		if (!usuarioRepository.existsByNickname(usuario.getNickname())) {
			return ResponseEntity.noContent().build();
		}
		Usuario auxUsuario = usuarioRepository.findByNickname(usuario.getNickname());
		auxUsuario.setUltimoAcceso(usuario.getUltimoAcceso());
		auxUsuario = usuarioRepository.save(auxUsuario);
		return new ResponseEntity<Usuario>(auxUsuario, HttpStatus.OK);
	}

	@PutMapping(path ="/usuario/rol")
	public ResponseEntity<Usuario> asignacionRolUsuario(@RequestBody Usuario usuario) {
		if (!usuarioRepository.existsByNickname(usuario.getNickname())) {
			return ResponseEntity.noContent().build();
		}
		Usuario auxUsuario = usuarioRepository.findByNickname(usuario.getNickname());
		Rol auxRol = rolRepository.findById(usuario.getRol().getId()).get();
		
		auxUsuario.setRol(auxRol);
		
		auxUsuario=usuarioRepository.save(auxUsuario);
		return new ResponseEntity<Usuario>(auxUsuario, HttpStatus.OK);
	}

	@DeleteMapping(path="/usuario/{nickname}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable String nickname) {

		if (usuarioRepository.existsByNickname(nickname)) {
			usuarioRepository.deleteByNickname(nickname);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

}
