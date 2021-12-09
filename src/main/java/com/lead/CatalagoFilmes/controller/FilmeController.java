package com.lead.CatalagoFilmes.controller;

import java.util.List;

import com.lead.CatalagoFilmes.model.Categoria;
import com.lead.CatalagoFilmes.service.CategoriaService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import com.lead.CatalagoFilmes.model.Filme;
import com.lead.CatalagoFilmes.service.FilmeService;

@Controller
@RequestMapping(value = "/filme")
public class FilmeController {

	@Autowired
	private FilmeService filmeService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/filmes")
	public ResponseEntity<List<Filme>> listaFilmes() {
		return ResponseEntity.ok().body(filmeService.findAll());
	}

	@GetMapping("/filmeBusca/{tituloFilme}")
	public ResponseEntity<List<Filme>> searchName(@PathVariable String tituloFilme) {
		return ResponseEntity.ok().body(filmeService.searchName(tituloFilme));
	}

	@GetMapping("/filmeById/{id}")
	public ResponseEntity<Filme> listaFilmeById(@PathVariable Long id) {
		return ResponseEntity.ok().body(filmeService.findById(id));
	}

	@PostMapping("/salvaFilme")
	public ResponseEntity<Filme> salvaFilme(@RequestBody Filme filme) {
		return ResponseEntity.ok().body(filmeService.save(filme));
	}

	@PutMapping("/atualizaFilme")
	public ResponseEntity<Filme> atualizaFilme(@RequestBody Filme filme) {
		return ResponseEntity.ok().body(filmeService.update(filme));
	}

	@DeleteMapping("/deleteFilmeById/{id}")
	public ResponseEntity<String> deleteFilmeById(@PathVariable Long id) {
		return ResponseEntity.ok().body(filmeService.deleteById(id));
	}

	@GetMapping("/getFilmesByCategoria/{id}")
	public ResponseEntity<List<Filme>> findByCategoria(@PathVariable Long id){
		return ResponseEntity.ok().body(filmeService.findByCategoria(id));
	}


}
