package com.lead.CatalagoFilmes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lead.CatalagoFilmes.model.Usuario;
import com.lead.CatalagoFilmes.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public String deleteById(Long id) {
		usuarioRepository.deleteById(id);
		return "deletado com sucesso.";
	}

	public boolean verificaId(Long id){ return usuarioRepository.existsById(id); }
}
