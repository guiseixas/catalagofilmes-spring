package com.lead.CatalagoFilmes.config.testConfig;

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

import javax.persistence.Id;
import java.util.Arrays;


    @Configuration
    public class TestConfig implements CommandLineRunner {
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
            ingles.setTag("EN-USA");

            Idioma portugues = new Idioma();
            portugues.setId(1L);
            portugues.setNome("Português-brasileiro");
            portugues.setTag("PT-BR");

            Idioma espanhol = new Idioma();
            espanhol.setId(null);
            espanhol.setNome("Espanhol-AMSUL");
            espanhol.setTag("ESP-SUL");

            Categoria aventura = new Categoria();
            aventura.setId(null);
            aventura.setNome("Aventura");
            aventura.setTag("AVENT");

            Categoria drama = new Categoria();
            drama.setId(1L);
            drama.setNome("Drama");
            drama.setTag("DRM");
            drama.setIdioma(portugues);

            Filme filme = new Filme(null, "The secret life of ElanoDescomplica", "Elano vivi no seu mundo da lua e de repente encontra o seu real propósito de vida", "fingi que realmente tem uma imagem", "20/12/2013", "1h 54min", portugues, drama);
            Filme filme2 = new Filme(null, "Cleber, o cacto", "O filme retrata a vida diária de Cleber e sua vida de cacto apreciando o sol e uma brisa", "Finge que tem uma imagem aqui", "20/01/2021", "1hr", portugues, aventura);


            Usuario Elano = new Usuario(null, "Elano", "000-000-000-00", "+00-000-00000000", "elanoDescomplica@email.com", "$2a$10$K4HhGAJZy6jU./HceF1OieghevmxiCmuIybWYr04M6pPhs..d7jFm", ingles);
            Usuario Cleber = new Usuario(null, "Cleber", "000.000.000-00", "+000000000-0000", "emailDescomplica@email.com", "queSenha?", portugues);

            /*idiomaRepository.saveAll(Arrays.asList(ingles, portugues));
            categoriaRepository.saveAll(Arrays.asList(aventura, drama));
            filmeRepository.saveAll(Arrays.asList(filme, filme2));
            usuarioRepository.saveAll(Arrays.asList(Elano, Cleber));
             */

        }
    }
