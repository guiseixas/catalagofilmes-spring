package com.lead.CatalagoFilmes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lead.CatalagoFilmes.model.Idioma;
import com.lead.CatalagoFilmes.repository.IdiomaRepository;

@Service
public class IdiomaService {

	@Autowired
	IdiomaRepository idiomaRepository;
	
	public List<Idioma> findAll(){
		return idiomaRepository.findAll();
	}
	
	public Optional<Idioma> findById(Long id) {
		return idiomaRepository.findById(id);
	}
	
	public Idioma save(Idioma idioma) {
		return idiomaRepository.save(idioma);
	}
	
	public Idioma update(Idioma idioma) {
		return idiomaRepository.save(idioma);
	}
	
	public String deleteById(Long id) {
		idiomaRepository.deleteById(id);
		return "deletado com sucesso.";
	}

	public boolean verificaId(Long id){ return idiomaRepository.existsById(id); }
}
