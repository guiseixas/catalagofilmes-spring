package com.lead.CatalagoFilmes.model;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Idioma {
    
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
    @Column(name = "IDIOMA_TAG")
    private String tag;

    @Column(name = "IDIOMA_NOME")
    private String nome;

}
