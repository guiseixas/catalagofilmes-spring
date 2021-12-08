package com.lead.CatalagoFilmes.model;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Usuario {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@Column
	private String cpf;

	@Column
	private String telefone;

	@Column
	private String email;

	@Column
	private String senha;

	@OneToOne
	private Idioma idioma;
}