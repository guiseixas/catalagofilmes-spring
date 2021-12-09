package com.lead.CatalagoFilmes.config;

import com.lead.CatalagoFilmes.model.Categoria;
import com.lead.CatalagoFilmes.model.Filme;
import com.lead.CatalagoFilmes.model.Idioma;
import com.lead.CatalagoFilmes.model.Usuario;
import com.lead.CatalagoFilmes.repository.CategoriaRepository;
import com.lead.CatalagoFilmes.repository.FilmeRepository;
import com.lead.CatalagoFilmes.repository.IdiomaRepository;
import com.lead.CatalagoFilmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


    @Configuration
    public class testConfig implements CommandLineRunner {
        @Autowired
        private IdiomaRepository idiomaRepository;
        @Autowired
        private UsuarioRepository usuarioRepository;
        @Autowired
        private CategoriaRepository categoriaRepository;
        @Autowired
        private FilmeRepository filmeRepository;

        @Override
        public void run(String... args) throws Exception {

            Idioma ingles = new Idioma();
            ingles.setId(null);
            ingles.setNome("Inglês");
            ingles.setTag("En");

            Idioma portugues = new Idioma();
            portugues.setId(null);
            portugues.setNome("Português-brasileiro");
            portugues.setTag("PT-BR");

            Categoria aventura = new Categoria();

            aventura.setId(null);

            aventura.setNome("aventura");
            aventura.setTag("avent");

            Filme filme = new Filme(null, "The secret life of ElanoDescomplica", "Elano vivi no seu mundo da lua e de repente encontra o seu real propósito de vida", "fingi que realmente tem uma imagem", "20/12/2013", "1h 54min", portugues, aventura);
            Filme filme2 = new Filme(null, "Cleber, o cacto", "O filme retrata a vida diária de Cleber e sua vida de cacto apreciando o sol e uma brisa", "Finge que tem uma imagem aqui", "20/01/2021", "1hr", portugues, aventura);


            Usuario Elano = new Usuario(null, "Elano", "000-000-000-00", "+00-000-00000000", "elanoDescomplica@email.com", "queSenha", ingles);
            Usuario Cleber = new Usuario(null, "Cleber", "000.000.000-00", "+000000000-0000", "emailDescomplica@email.com", "queSenha?", portugues);

            idiomaRepository.saveAll(Arrays.asList(ingles, portugues));
            categoriaRepository.saveAll(Arrays.asList(aventura));
            filmeRepository.saveAll(Arrays.asList(filme, filme2));
            usuarioRepository.saveAll(Arrays.asList(Elano, Cleber));
        }
    }
