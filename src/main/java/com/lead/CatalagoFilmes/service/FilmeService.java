package com.lead.CatalagoFilmes.service;

import org.springframework.stereotype.Service;

import com.lead.CatalagoFilmes.model.Filme;
import com.lead.CatalagoFilmes.repository.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FilmeService {

	@Autowired
	FilmeRepository filmeRepository;
	
	public List<Filme> findAll() {
		return filmeRepository.findAll();
	}
	
	public Filme findById(Long id) {
		return filmeRepository.findById(id).get();
	}
	
	public Filme save(Filme filme) {
		return filmeRepository.save(filme);
	}
	
	public Filme update(Filme filme) {
		return filmeRepository.save(filme);
	}
	
	public String deleteById(Long id) {
		filmeRepository.deleteById(id);
		return "deletado com sucesso.";
	}
}
