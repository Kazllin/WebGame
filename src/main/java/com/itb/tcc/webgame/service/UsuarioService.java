package com.itb.tcc.webgame.service;

import java.util.List;

import com.itb.tcc.webgame.model.Usuario;

public interface UsuarioService {
	List<Usuario> getAllUsuario();
	
	Usuario getUsuarioById(Long id);
	
	Usuario updateUsuario(Usuario usuario);

	void deleteUsuarioById(Long id);
	




	


	
	
}
