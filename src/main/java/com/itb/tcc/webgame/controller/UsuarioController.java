package com.itb.tcc.webgame.controller;

import java.util.List;
import java.io.IOException;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PathVariable;

import com.itb.tcc.webgame.model.Usuario;
import com.itb.tcc.webgame.repository.UsuarioRepository;
import com.itb.tcc.webgame.service.UsuarioService;

@Controller
@RequestMapping("/web-game/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	private UsuarioService usuarioService;
	private Object usuarioBanco;
	
	
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	//Formulario

	@GetMapping("/Inicio")
	public String showInicio() {
		return"index";
	}
	
	@GetMapping("/novo-usuario")
	public String novoUsuario(Usuario usuario, Model model) {
	model.addAttribute("usuario",usuario);
	 return "Formulario";
	}
	
	
	
	@PostMapping("/add-usuario")
	public String addUsuario(Usuario usuario, Model model) {
		
		
		@SuppressWarnings("unused")
		Usuario usuarioBanco = usuarioRepository.save(usuario);
		
		return "redirect:/web-game/usuario/login";
	}
	
	@GetMapping ("/login")
	public String showFormLogin(Usuario usuario, Model model) {
		return "login";
	}
	
	
	@PostMapping("/login")
	public String efetuarLogin(Usuario usuario, String urlRedirect) {
		
		String urlRedirect1 = "redirect:/web-game/usuario/login";
		
		Usuario usuarioDb =usuarioRepository.findByEmail(usuario.getEmail());
				
				if(usuarioDb != null && usuarioDb.getSenha().equals(usuario.getSenha())) {
					 urlRedirect1 = "redirect:/web-game/usuario/perfil";
				}
		
		return urlRedirect1;
	}
	
	@GetMapping("/perfil")
	public String showPerfil() {
		return"home";
	}
	
	@GetMapping("/crud")
	public String showCrud(Model model) {
		model.addAttribute("crud", usuarioService.getAllUsuario());
		return"crud";
	}
	
	@GetMapping("/edit/{id}")	
	public String editUsuario(@PathVariable("id") long id, ModelMap model,Usuario usuario) {
	  Usuario usuario1 = usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid prod Id:" + id));
		model.addAttribute("usuario",usuario1);
		return "editar-usuario";
		
	}
	
	@PostMapping("/salvo/{id}")
	public String updateUsuario( @PathVariable("id") int id,
			@ModelAttribute("usuario") Usuario usuario, Model model) {
		
		  Usuario usuario1 = usuarioRepository.findById(usuario.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid prod Id:" + id));
		
		
		   
			usuario1.setNome(usuario.getNome());
			usuario1.setEmail(usuario.getEmail());
			usuario1.setTelefone(usuario.getTelefone());
			usuario1.setEndereco(usuario.getEndereco());
			usuario1.setUf(usuario.getUf());
			usuario1.setCep(usuario.getCep());
			
			usuarioRepository.save(usuario);

		

		
		
		return "redirect:/web-game/usuario/crud";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUsuario(@PathVariable("id") long id) {
		usuarioService.deleteUsuarioById(id);
		return "redirect:/web-game/usuario/crud";
		
	}
	
}
