package com.lead.CatalagoFilmes;

import lombok.Getter;

@Getter
public class Usuario {

	private String nome;
	private String cpf;
	private int idade;
	private String agencia;
	private String conta;

	public Usuario(String nome, String cpf, int idade, String agencia, String conta) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.agencia = agencia;
		this.conta = conta;
	}
	
}
