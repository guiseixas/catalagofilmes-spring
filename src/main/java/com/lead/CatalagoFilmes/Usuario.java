package com.lead.CatalagoFilmes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

	private String nome;
	private String cpf;
	private int idade;
	private String agencia;
	private String conta;

	public Usuario(){

	}

	public Usuario(String nome, String cpf, int idade, String agencia, String conta) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.agencia = agencia;
		this.conta = conta;
	}
	
}
