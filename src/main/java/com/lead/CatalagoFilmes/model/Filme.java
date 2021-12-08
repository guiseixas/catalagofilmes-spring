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
    private Long id;

    @Column
    private String titulo;

    @Column
    private String sinopse;

    @Column
    private String imagem;

    @Column
    private String dataLancamento;

    @Column
    private String duracao;

    @ManyToOne
    private Idioma idioma;

    @ManyToOne
    private Categoria categoria;
}