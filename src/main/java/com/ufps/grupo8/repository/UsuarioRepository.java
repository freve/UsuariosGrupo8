package com.ufps.grupo8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.grupo8.entities.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario,String> {

	Usuario findByNickname(String nickname);
	boolean existsByNickname(String nickname);
	List<Usuario>deleteByNickname(String nickname);
	
}
