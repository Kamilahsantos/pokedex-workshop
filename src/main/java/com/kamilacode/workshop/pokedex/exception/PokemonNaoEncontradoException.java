package com.kamilacode.workshop.pokedex.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Pokemon não encontrado na base")
public class PokemonNaoEncontradoException extends Exception{

    public PokemonNaoEncontradoException(Long id) {
        super("Pokemon com o id  " + id + " não localizado na base");
    }
}
