package com.lead.CatalagoFilmes.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.lead.CatalagoFilmes.model.Usuario;
import com.lead.CatalagoFilmes.service.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> listaUsuarios() {
		return ResponseEntity.ok().body(usuarioService.findAll());
	}

	@GetMapping("/usuarioById/{id}")
	public ResponseEntity<Usuario> listaUsuarioById(@PathVariable Long id) {
		return ResponseEntity.ok().body(usuarioService.findById(id));
	}

	@PostMapping("/salvaUsuario")
	public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.ok().body(usuarioService.save(usuario));
	}

	@PutMapping("/atualizaUsuario")
	public ResponseEntity<Usuario> atualizaUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.ok().body(usuarioService.update(usuario));
	}

	@DeleteMapping("/deleteUsuarioById/{id}")
	public ResponseEntity<String> deleteUsuarioById(@PathVariable Long id) {
		return ResponseEntity.ok().body(usuarioService.deleteById(id));
	}
}