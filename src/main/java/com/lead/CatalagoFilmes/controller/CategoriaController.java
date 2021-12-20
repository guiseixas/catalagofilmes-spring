package com.lead.CatalagoFilmes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<?> listaCategorias() {
		try{
			List<Categoria> categorias = categoriaService.findAll();
			if(categorias.isEmpty()){
				throw new Exception("Não há categorias cadastradas.");
			}
			return ResponseEntity.ok().body(categorias);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/categoriaById/{id}")
	public ResponseEntity<?> listaCategoriaById(@PathVariable Long id) {
		try {
			Categoria categoria = categoriaService.findById(id);
			if(categoria == null){
				return new ResponseEntity<String>("Não há categoria com o id especificado", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(categoria);
		} catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/salvaCategoria")
	public ResponseEntity<?> salvaCategoria(@RequestBody @Valid Categoria categoria) {
		try{
			return ResponseEntity.ok().body(categoriaService.save(categoria));
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/atualizaCategoria")
	public ResponseEntity<?> atualizaCategoria(@RequestBody @Valid Categoria categoria) {
		try{
			if(categoria == null){
				return new ResponseEntity<String>("Não há essa categoria.", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(categoriaService.update(categoria));
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteCategoriaById/{id}")
	public ResponseEntity<String> deleteCategoriaById(@PathVariable Long id) {
		try{
			String delete = categoriaService.deleteById(id);
			return ResponseEntity.ok().body(delete);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}