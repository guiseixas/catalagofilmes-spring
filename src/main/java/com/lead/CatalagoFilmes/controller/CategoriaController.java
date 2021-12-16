package com.lead.CatalagoFilmes.controller;

import java.util.List;

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
import com.lead.CatalagoFilmes.service.CategoriaService;
import com.lead.CatalagoFilmes.model.Categoria;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> listaCategorias() {
		return ResponseEntity.ok().body(categoriaService.findAll());
	}

	@GetMapping("/categoriaById/{id}")
	public ResponseEntity<Categoria> listaCategoriaById(@PathVariable Long id) {
		return ResponseEntity.ok().body(categoriaService.findById(id));
	}

	@PostMapping("/salvaCategoria")
	public ResponseEntity<Categoria> salvaCategoria(@RequestBody @Valid Categoria categoria) {
		return ResponseEntity.ok().body(categoriaService.save(categoria));
	}

	@PutMapping("atualizaCategoria")
	public ResponseEntity<Categoria> atualizaCategoria(@RequestBody @Valid Categoria categoria) {
		return ResponseEntity.ok().body(categoriaService.update(categoria));
	}

	@DeleteMapping("/deleteCategoriaById/{id}")
	public ResponseEntity<String> deleteCategoriaById(@PathVariable Long id) {
		return ResponseEntity.ok().body(categoriaService.deleteById(id));
	}
}