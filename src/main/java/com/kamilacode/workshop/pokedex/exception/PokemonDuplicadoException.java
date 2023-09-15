package com.kamilacode.workshop.pokedex.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Pokemon duplicado - já existe um pokemon com esse nome")
public class PokemonDuplicadoException extends Exception {
        public PokemonDuplicadoException() {
            super();
        }

        public PokemonDuplicadoException(String message) {
            super();
        }

    }
