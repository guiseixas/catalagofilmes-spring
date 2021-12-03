package com.lead.CatalagoFilmes.service;

import org.springframework.stereotype.Service;

import com.lead.CatalagoFilmes.model.Categoria;
import com.lead.CatalagoFilmes.repository.CategoriaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	public Categoria findById(Long id) {
		return categoriaRepository.findById(id).get();
	}
	
	//Primeiro a ser feito, gera o ID.
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	//O objeto tem um ID no método UPDATE.
	public Categoria update(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public String deleteById(Long id) {
		categoriaRepository.deleteById(id);
		return "deletado com sucesso.";
	}
	
}
