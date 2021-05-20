package com.ufps.grupo8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.grupo8.entities.Persona;

@Repository
@Transactional
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

	Persona findByDocumento(Long documento);
	boolean existsByDocumento(Long documento);
	List<Persona>deleteByDocumento(Long documento);
	
}
