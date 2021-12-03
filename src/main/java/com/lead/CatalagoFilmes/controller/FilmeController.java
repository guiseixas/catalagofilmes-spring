package com.lead.CatalagoFilmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lead.CatalagoFilmes.model.Filme;
import com.lead.CatalagoFilmes.service.FilmeService;

@Controller
@RequestMapping(value = "/filme")	
public class FilmeController {
	
	@Autowired
	FilmeService filmeService;
	
	@GetMapping("/filmes")
	public List<Filme> listaFilmes() {
		return filmeService.findAll();
	}
	
	@GetMapping("/filmesById")
	public Filme listaFilmesById(@RequestBody Long id) {
		return filmeService.findById(id);
	}
	
	@PostMapping("/salvaFilme")
	public Filme salvaFilme(@RequestBody Filme filme) {
		return filmeService.save(filme);
	}
	
	@PutMapping("/atualizaFilme")
	public Filme atualizaFilme(@RequestBody Filme filme) {
		return filmeService.update(filme);
	}

	@DeleteMapping("/deleteFilmeById")
	public String deleteFilmeById(@RequestBody Long id) {
		return filmeService.deleteById(id);
	}
}
