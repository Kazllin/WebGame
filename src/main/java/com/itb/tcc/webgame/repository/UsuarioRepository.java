package com.itb.tcc.webgame.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.itb.tcc.webgame.model.Usuario;
import com.itb.tcc.webgame.service.UsuarioService;
@Repository
public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario, Long> {

	@Query(value = "SELECT * FROM usuarios u WHERE u.email=?", nativeQuery = true)
	Usuario findByEmail(String email);

	Usuario getUsuarioById(Long id);



	
}
