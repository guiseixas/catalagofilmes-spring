package com.lead.CatalagoFilmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.lead.CatalagoFilmes.model.Usuario;
import com.lead.CatalagoFilmes.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> listaUsuarios() {
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuariosById")
	public Usuario listaUsuariosById(@RequestBody Long id) {
		return usuarioService.findById(id);
	}
	
	@PostMapping("/salvaUsuario")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
	@PutMapping("/atualizaUsuario")
	public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
		return usuarioService.update(usuario);
	}

	@DeleteMapping("/deleteUsuarioById")
	public String deleteUsuarioById(@RequestBody Long id) {
		return usuarioService.deleteById(id);
	}
}
