package com.kamilacode.workshop.pokedex.controller;


import com.kamilacode.workshop.pokedex.model.Pokemon;
import com.kamilacode.workshop.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {


    @Autowired
    private PokemonService pokemonService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pokemon criarPokemon(@RequestBody Pokemon pokemon) throws Exception {
        return pokemonService.criarPokemon(pokemon);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pokemon> listarPokemons() {
        return pokemonService.listarPokemons();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Pokemon> buscarPokemonPeloId(@PathVariable(value = "id") Long id) throws Exception {
        return pokemonService.buscarPokemonPeloId(id);

    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pokemon> atualizarPokemonPeloId(@PathVariable(value = "id") Long id, @RequestBody Pokemon pokemonModel) {
        return pokemonService.atualizarPokemonPeloId(pokemonModel, id);

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> excluirPokemonPeloId(@PathVariable(value = "id") Long id) {
        return pokemonService.excluirPokemonPeloId(id);

    }

}
