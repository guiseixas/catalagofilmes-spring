package com.lead.CatalagoFilmes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Filme {
    
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
    @Column(name = "FILME_SINOPSE")
    private String sinopse;

    @Column(name = "FILME_TITULO")
    private String titulo;

    @Column(name = "FILME_LANCAMENTO")
    private String dataLancamento;

    @Column(name = "FILME_DURACAO")
    private String duracao;

    @ManyToOne
    private Idioma idioma;
    
    @ManyToOne
    private Categoria categoria;
}