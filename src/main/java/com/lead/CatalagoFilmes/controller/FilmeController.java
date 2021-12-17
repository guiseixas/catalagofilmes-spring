package com.lead.CatalagoFilmes.controller;

import java.util.List;

import com.lead.CatalagoFilmes.model.Categoria;
import com.lead.CatalagoFilmes.service.CategoriaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
import com.lead.CatalagoFilmes.model.Filme;
import com.lead.CatalagoFilmes.service.FilmeService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/filme")
public class FilmeController {

	@Autowired
	private FilmeService filmeService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/filmes")
	public ResponseEntity<?> listaFilmes() {
		try{
			List<Filme> filmes = filmeService.findAll();
			if(filmes.isEmpty()){
				throw new Exception("Não há filmes cadastrados.");
			}
			return ResponseEntity.ok().body(filmes);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/filmeBusca/{tituloFilme}")
	public ResponseEntity<?> searchName(@PathVariable String tituloFilme) {
		try{
			List<Filme> filmes = filmeService.searchName(tituloFilme);
			if(filmes.isEmpty()){
				throw new Exception("Não há filmes cadastrados com este nome.");
			}
			return ResponseEntity.ok().body(filmes);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/filmeById/{id}")
	public ResponseEntity<?> listaFilmeById(@PathVariable Long id) {
		try{
			Filme filme = filmeService.findById(id);
			if(filme == null){
				return new ResponseEntity<String>("Não há filme com o id especificado.", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(filme);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/salvaFilme")
	public ResponseEntity<?> salvaFilme(@RequestBody @Valid Filme filme) {
		try{
			return ResponseEntity.ok().body(filmeService.save(filme));
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/atualizaFilme")
	public ResponseEntity<?> atualizaFilme(@RequestBody @Valid Filme filme) {
		try{
			if(filme == null){
				return new ResponseEntity<String>("Não há esse filme.", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(filmeService.update(filme));
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteFilmeById/{id}")
	public ResponseEntity<?> deleteFilmeById(@PathVariable Long id) {
		try{
			String delete = filmeService.deleteById(id);
			if(delete != "deletado com sucesso."){
				return new ResponseEntity<String>("Não há filme com o id especificado", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(delete);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getFilmesByCategoria/{id}")
	public ResponseEntity<?> findByCategoria(@PathVariable Long id){
		try{
			List<Filme> filmes = filmeService.findByCategoria(id);
			if(filmes.isEmpty()){
				throw new Exception("Não há filmes cadastrados para esse id de categoria.");
			}
			return ResponseEntity.ok().body(filmes);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}


}
