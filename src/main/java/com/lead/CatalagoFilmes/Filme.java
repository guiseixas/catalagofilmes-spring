package com.lead.CatalagoFilmes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Filme {
    private String titulo;
    private String sinopse;
    private Categoria categoria;
    private String dataLancamento;
    private String duracao;
    private Idioma idioma;
    private String imagem;

    public Filme(){

    }

    public Filme(String titulo, String sinopse, Categoria categoria, String dataLancamento, String duracao, Idioma idioma, String imagem) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.categoria = categoria;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.idioma = idioma;
        this.imagem = imagem;
    }
}
