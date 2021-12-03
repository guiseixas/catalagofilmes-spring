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
import com.lead.CatalagoFilmes.service.CategoriaService;
import com.lead.CatalagoFilmes.model.Categoria;

@Controller
@RequestMapping(value = "/categoria")	
public class CategoriaController {	
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping("/categorias")
	public List<Categoria> listaCategorias() {
		return categoriaService.findAll();
	}
	
	@GetMapping("/categoriasById")
	public Categoria listaCategoriasById(@RequestBody Long id) {
		return categoriaService.findById(id);
	}
	
	@PostMapping("/salvaCategoria")
	public Categoria salvaCategoria(@RequestBody Categoria categoria) {
		return categoriaService.save(categoria);
	}
	
	@PutMapping("atualizaCategoria")
	public Categoria atualizaCategoria(@RequestBody Categoria categoria) {
		return categoriaService.update(categoria);
	}

	@DeleteMapping("/deleteCategoriaById")
	public String deleteCategoriaById(@RequestBody Long id) {
		return categoriaService.deleteById(id);
	}
	
}
