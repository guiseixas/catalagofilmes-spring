package com.lead.CatalagoFilmes.model;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String tag;

    @ManyToOne
    private Idioma idioma;
}
