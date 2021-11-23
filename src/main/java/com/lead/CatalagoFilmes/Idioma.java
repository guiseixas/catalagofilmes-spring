package com.lead.CatalagoFilmes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Idioma {
    private String nome;
    private String tag;

    public Idioma() {

    }

    public Idioma(String nome, String tag) {
        this.nome = nome;
        this.tag = tag;
    }
}