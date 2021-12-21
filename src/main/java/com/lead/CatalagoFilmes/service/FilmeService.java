package com.lead.CatalagoFilmes.service;


import com.lead.CatalagoFilmes.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lead.CatalagoFilmes.model.Filme;
import com.lead.CatalagoFilmes.repository.FilmeRepository;
import java.util.List;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private CategoriaService categoriaService;

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

	public boolean verificaId(Long id){
		if(filmeRepository.existsById(id)) {
			return true;
		}else{
			return false;
		}
	}

	public List<Filme> searchName(String tituloFilme){ return filmeRepository.searchName(tituloFilme); }

	public List<Filme> findByCategoria(Long id){
		Categoria c = categoriaService.findById(id);
		if(c != null) {
			return filmeRepository.findByCategoria(c);
		}
		return null;
	}
}
