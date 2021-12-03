package com.lead.CatalagoFilmes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.lead.CatalagoFilmes.model.Idioma;
import com.lead.CatalagoFilmes.service.IdiomaService;

@Controller
public class IdiomaController {
	
	@Autowired
	IdiomaService idiomaService;
	
	@GetMapping("/idiomas")
	public List<Idioma> listaIdiomas() {
		return idiomaService.findAll();
	}
	
	@GetMapping("/idiomasById")
	public Idioma listaIdiomasById(@RequestBody Long id) {
		return idiomaService.findById(id);
	}
	
	@PostMapping("/salvaIdioma")
	public Idioma salvaIdioma(@RequestBody Idioma idioma) {
		return idiomaService.save(idioma);
	}
	
	@PutMapping("/atualizaIdioma")
	public Idioma atualizaIdioma(@RequestBody Idioma idioma) {
		return idiomaService.update(idioma);
	}

	@DeleteMapping("/deleteIdiomaById")
	public String deleteIdiomaById(@RequestBody Long id) {
		return idiomaService.deleteById(id);
	}
}
