package com.lead.CatalagoFilmes.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/usuarios")
	public ResponseEntity<?> listaUsuarios() {
		try{
			List<Usuario> usuarios = usuarioService.findAll();
			if(usuarios.isEmpty()){
				throw new Exception("Não há usuários cadastrados.");
			}
			return ResponseEntity.ok().body(usuarios);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/usuarioById/{id}")
	public ResponseEntity<?> listaUsuarioById(@PathVariable Long id) {
		try{
			Usuario usuario = usuarioService.findById(id);
			if(usuario == null){
				return new ResponseEntity<String>("Não há usuário com o id especificado.", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(usuario);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/salvaUsuario")
	public ResponseEntity<?> salvaUsuario(@RequestBody @Valid Usuario usuario) {
		try{
			return ResponseEntity.ok().body(usuarioService.save(usuario));
		}catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/atualizaUsuario")
	public ResponseEntity<?> atualizaUsuario(@RequestBody @Valid Usuario usuario) {
		try {
			if(usuario == null){
				return new ResponseEntity<String>("Não há esse usuario.", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(usuarioService.update(usuario));
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteUsuarioById/{id}")
	public ResponseEntity<String> deleteUsuarioById(@PathVariable Long id) {
		try{
			String delete = usuarioService.deleteById(id);
			return ResponseEntity.ok().body(delete);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}