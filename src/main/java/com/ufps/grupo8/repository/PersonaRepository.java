package com.ufps.grupo8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufps.grupo8.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

	Persona findByDocumento(Long documento);
	
}
