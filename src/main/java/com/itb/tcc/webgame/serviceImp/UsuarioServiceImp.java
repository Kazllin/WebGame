package com.itb.tcc.webgame.serviceImp;


import java.util.List;

import org.springframework.stereotype.Service;
import com.itb.tcc.webgame.model.Usuario;
import com.itb.tcc.webgame.repository.UsuarioRepository;
import com.itb.tcc.webgame.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {

	
	private UsuarioRepository usuarioRepository;

	private Long id;
	
	public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<Usuario> getAllUsuario() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuarioById(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteUsuarioById(Long id) {
		usuarioRepository.deleteById(id);
		
	}



	

}
