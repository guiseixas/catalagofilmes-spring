package com.lead.CatalagoFilmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalagoFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalagoFilmesApplication.class, args);
		
		Usuario u = new Usuario(null, null, 0, null, null);
		
		
	}

}
