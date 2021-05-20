package com.ufps.grupo8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufps.grupo8.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {

}
