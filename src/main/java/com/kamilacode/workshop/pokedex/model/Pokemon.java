package com.kamilacode.workshop.pokedex.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public Pokemon() {
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<String> getEvolucoes() {
        return evolucoes;
    }

    public void setEvolucoes(List<String> evolucoes) {
        this.evolucoes = evolucoes;
    }


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @Column(nullable = false, unique = true)
    String nome;
    @Column(nullable = false)
    String tipo;
    @Column
    List<String> evolucoes;


    public Pokemon(Long id, String nome, String tipo, List<String> evolucoes) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.evolucoes = evolucoes;
    }

}
