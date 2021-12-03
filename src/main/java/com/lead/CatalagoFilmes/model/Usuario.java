package com.lead.CatalagoFilmes.model;

import lombok.*;
import org.springframework.stereotype.Component;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Component
@Entity
public class Usuario {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="USER_CPF", unique = true)
	private String cpf;

	@Column(name = "USER_NOME")
	private String nome;

	@Column(name = "USER_TELEFONE")
	private String telefone;

	@Column(name = "USER_EMAIL")
	private String email;

	@Column(name = "USER_SENHA")
	private String senha;

	@Column(name = "USER_IMAGEM")
	private String imagem;

}
