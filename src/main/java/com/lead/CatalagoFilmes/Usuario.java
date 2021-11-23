package com.lead.CatalagoFilmes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Usuario {

	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String senha;
	private Idioma idioma;

	public Usuario(){

	}
	public Usuario(String nome, String cpf, String telefone, String email, String senha, Idioma idioma) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.idioma = idioma;
	}
}
