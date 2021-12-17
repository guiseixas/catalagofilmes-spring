package com.lead.CatalagoFilmes.controller;

import java.util.List;

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
import com.lead.CatalagoFilmes.model.Idioma;
import com.lead.CatalagoFilmes.service.IdiomaService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/idioma")
public class IdiomaController {

	@Autowired
	private IdiomaService idiomaService;

	@GetMapping("/idiomas")
	public ResponseEntity<?> listaIdiomas() {
		try {
			List<Idioma> idiomas = idiomaService.findAll();
			if(idiomas.isEmpty()){
				throw new Exception("Não há idiomas cadastrados.");
			}
			return ResponseEntity.ok().body(idiomas);
		} catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/idiomaById/{id}")
	public ResponseEntity<?> listaIdiomaById(@PathVariable Long id) {
		try{
			Idioma idioma = idiomaService.findById(id);
			if(idioma == null){
				return new ResponseEntity<String>("Não há idioma com o id especificado.", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(idioma);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/salvaIdioma")
	public ResponseEntity<?> salvaIdioma(@RequestBody @Valid Idioma idioma) {
		try{
			return ResponseEntity.ok().body(idiomaService.save(idioma));
		}catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/atualizaIdioma")
	public ResponseEntity<?> atualizaIdioma(@RequestBody @Valid Idioma idioma) {
		try{
			if(idioma == null){
				return new ResponseEntity<String>("Não há esse idioma.", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(idiomaService.update(idioma));
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteIdiomaById/{id}")
	public ResponseEntity<?> deleteIdiomaById(@PathVariable Long id) {
		try{
			String delete = idiomaService.deleteById(id);
			if(delete != "deletado com sucesso."){
				return new ResponseEntity<String>("Não há idioma com o id especificado", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(delete);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}