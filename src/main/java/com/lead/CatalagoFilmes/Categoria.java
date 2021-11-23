package com.lead.CatalagoFilmes;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter

public class Categoria {
    private String nome;
    private String tag;
    private ArrayList<Filme> filmes = new ArrayList<>();

    public Categoria(){

    }

    public Categoria(String nome, String tag) {
        this.nome = nome;
        this.tag = tag;
    }
}
