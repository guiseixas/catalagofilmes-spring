package com.lead.CatalagoFilmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lead.CatalagoFilmes.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
