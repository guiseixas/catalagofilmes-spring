package com.lead.CatalagoFilmes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/filme/filmes").permitAll()
                .antMatchers(HttpMethod.GET, "filme/filmeBusca/*").permitAll()
                .antMatchers(HttpMethod.GET, "filme/filmeById/*").permitAll()
                .antMatchers(HttpMethod.GET, "categoria/categorias").permitAll()
                .antMatchers(HttpMethod.GET, "categoria/categoriaById/*").permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("guilherme").password("123").roles("USER")
                .and()
                .withUser("admin").password("123").roles("USER", "ADMIN");
    }
}
