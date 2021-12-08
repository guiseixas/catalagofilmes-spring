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
import com.lead.CatalagoFilmes.model.Idioma;
import com.lead.CatalagoFilmes.service.IdiomaService;

@Controller
@RequestMapping(value = "/idioma")
public class IdiomaController {

	@Autowired
	private IdiomaService idiomaService;

	@GetMapping("/idiomas")
	public ResponseEntity<List<Idioma>> listaIdiomas() {
		return ResponseEntity.ok().body(idiomaService.findAll());
	}

	@GetMapping("/idiomaById/{id}")
	public ResponseEntity<Idioma> listaIdiomaById(@PathVariable Long id) {
		return ResponseEntity.ok().body(idiomaService.findById(id));
	}

	@PostMapping("/salvaIdioma")
	public ResponseEntity<Idioma> salvaIdioma(@RequestBody Idioma idioma) {
		return ResponseEntity.ok().body(idiomaService.save(idioma));
	}

	@PutMapping("/atualizaIdioma")
	public ResponseEntity<Idioma> atualizaIdioma(@RequestBody Idioma idioma) {
		return ResponseEntity.ok().body(idiomaService.update(idioma));
	}

	@DeleteMapping("/deleteIdiomaById/{id}")
	public ResponseEntity<String> deleteIdiomaById(@PathVariable Long id) {
		return ResponseEntity.ok().body(idiomaService.deleteById(id));
	}
}