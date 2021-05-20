package com.ufps.grupo8.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.grupo8.entities.Permiso;

@Repository
@Transactional
public interface PermisoRepository extends JpaRepository<Permiso, Integer>{

	
}
