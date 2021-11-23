package com.lead.CatalagoFilmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalagoFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalagoFilmesApplication.class, args);

		Idioma portugues = new Idioma("Portugues", "pt");
		Categoria drama = new Categoria();
		//drama.setNome("drama");
		Filme harryPotter = new Filme();
		harryPotter.setIdioma(portugues);
		harryPotter.setCategoria(drama);

		System.out.println(harryPotter.getIdioma().getNome());
	}
}
